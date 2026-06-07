package dev.Client.Controllers;

import dev.Client.Dto.TuristaDto;
import dev.Client.Services.TuristaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turistas")
public class TuristaController {

    private final TuristaService turistaService;

    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
    }

    @PostMapping
    public ResponseEntity<TuristaDto.Response> cadastrar(@RequestBody TuristaDto.Request dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turistaService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuristaDto.Response> atualizar(@PathVariable Long id,
                                                          @RequestBody TuristaDto.Request dto) {
        return ResponseEntity.ok(turistaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Long> contarTotal() {
        return ResponseEntity.ok(turistaService.contarTotal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuristaDto.Response> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turistaService.buscarPorId(id));
    }

    @GetMapping("/{id}/historico")
    public ResponseEntity<List<TuristaDto.HistoricoResponse>> buscarHistorico(@PathVariable Long id) {
        return ResponseEntity.ok(turistaService.buscarHistorico(id));
    }
}