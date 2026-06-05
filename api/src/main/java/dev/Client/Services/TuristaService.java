import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.passly.passly.entity.Visitacao;
import java.util.stream.Collectors;

@Service
public class TuristaService {

    @Autowired
    private TuristaRepository turistaRepository;

    public TuristaDTO.Response cadastrar(TuristaDTO.Request dto) {
        if (turistaRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("Já existe um turista com esse CPF.");
        }
        Turista turista = new Turista(
            dto.getNome(),
            dto.getCpf(),
            dto.getEmail(),
            dto.getTelefone(),
            dto.getPassaporte(),
            dto.getDataNascimento()
        );
        return new TuristaDTO.Response(turistaRepository.save(turista));
    }

    public TuristaDTO.Response atualizar(Long id, TuristaDTO.Request dto) {
        Turista turista = turistaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));
        turista.setNome(dto.getNome());
        turista.setEmail(dto.getEmail());
        turista.setTelefone(dto.getTelefone());
        turista.setPassaporte(dto.getPassaporte());
        turista.setDataNascimento(dto.getDataNascimento());
        return new TuristaDTO.Response(turistaRepository.save(turista));
    }

    public void deletar(Long id) {
        if (!turistaRepository.existsById(id)) {
            throw new RuntimeException("Turista não encontrado com id: " + id);
        }
        turistaRepository.deleteById(id);
    }

    public TuristaDTO.Response buscarPorId(Long id) {
        Turista turista = turistaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));
        return new TuristaDTO.Response(turista);
    }

    public List<TuristaDTO.HistoricoResponse> buscarHistorico(Long id) {
        Turista turista = turistaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Turista não encontrado com id: " + id));
        return turista.getHistorico()
            .stream()
            .map(TuristaDTO.HistoricoResponse::new)
            .collect(Collectors.toList());
    }
}