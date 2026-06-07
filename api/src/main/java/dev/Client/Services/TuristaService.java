package dev.Client.Services;

import dev.Client.Dto.TuristaDto;
import dev.Client.Entity.TuristaEntity;
import dev.Client.Repository.TuristaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TuristaService {

    
    private final TuristaRepository turistaRepository;

    public TuristaService(TuristaRepository turistaRepository) {
        this.turistaRepository = turistaRepository;
    }

    public TuristaDto.Response cadastrar(TuristaDto.Request dto) {
        if (turistaRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("Já existe um turista com esse CPF.");
        }

        
        TuristaEntity turista = new TuristaEntity(
                dto.getNome(),
                dto.getCpf(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getPassaporte(),
                dto.getDataNascimento()
        );

        return new TuristaDto.Response(turistaRepository.save(turista));
    }

    public TuristaDto.Response atualizar(Long id, TuristaDto.Request dto) {
        TuristaEntity turista = turistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));

        turista.setNome(dto.getNome());
        turista.setEmail(dto.getEmail());
        turista.setTelefone(dto.getTelefone());
        turista.setPassaporte(dto.getPassaporte());
        turista.setDataNascimento(dto.getDataNascimento());

        return new TuristaDto.Response(turistaRepository.save(turista));
    }

    public void deletar(Long id) {
        if (!turistaRepository.existsById(id)) {
            throw new RuntimeException("Turista não encontrado com id: " + id);
        }
        turistaRepository.deleteById(id);
    }

    public TuristaDto.Response buscarPorId(Long id) {
        TuristaEntity turista = turistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));
        return new TuristaDto.Response(turista);
    }

    public List<TuristaDto.HistoricoResponse> buscarHistorico(Long id) {
        TuristaEntity turista = turistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));
        return turista.getHistorico()
                .stream()
                .map(TuristaDto.HistoricoResponse::new)
                .collect(Collectors.toList());
    }
}