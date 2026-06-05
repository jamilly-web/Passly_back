import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turista")
public class TuristaController {

    @Autowired
    private TuristaService turistaService;

    @PostMapping
    public ResponseEntity<TuristaDTO.Response> cadastrar(
            @RequestBody TuristaDTO.Request dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(turistaService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuristaDTO.Response> atualizar(
            @PathVariable Long id,
            @RequestBody TuristaDTO.Request dto) {
        return ResponseEntity.ok(turistaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuristaDTO.Response> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(turistaService.buscarPorId(id));
    }

    @GetMapping("/{id}/historico")
    public ResponseEntity<List<TuristaDTO.HistoricoResponse>> buscarHistorico(
            @PathVariable Long id) {
        return ResponseEntity.ok(turistaService.buscarHistorico(id));
    }
}