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
    
        // Use default constructor and setters because TuristaEntity may not have a matching all-args constructor
        TuristaEntity turista = new TuristaEntity();
        turista.setNome(dto.getNome());
        turista.setCpf(dto.getCpf());
        turista.setEmail(dto.getEmail());
        turista.setTelefone(dto.getTelefone());
        turista.setDataNascimento(dto.getDataNascimento());

        return new TuristaDto.Response(turistaRepository.save(turista));
    }

    public TuristaDto.Response atualizar(Long id, TuristaDto.Request dto) {
        TuristaEntity turista = turistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));

        turista.setNome(dto.getNome());
        turista.setEmail(dto.getEmail());
        turista.setTelefone(dto.getTelefone());
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
        throw new RuntimeException("Histórico não disponível para Turista. Verifique a implementação de TuristaEntity.");
    }
}