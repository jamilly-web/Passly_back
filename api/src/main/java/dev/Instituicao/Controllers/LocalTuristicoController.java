package dev.Instituicao.Controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.Instituicao.Entity.LocalTuristicoEntity;
import dev.Instituicao.Entity.VisitacaoEntity;
import dev.Instituicao.Services.LocalTuristicoService;

@RestController
@RequestMapping("/localTuristico")
public class LocalTuristicoController {

    private final LocalTuristicoService service;

    // ✅ @Autowired vai no construtor para injetar o Service
    public LocalTuristicoController(LocalTuristicoService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<LocalTuristicoEntity> criar(
        @RequestBody LocalTuristicoEntity localTuristicoEntity) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(
        @PathVariable long id,
        @RequestBody LocalTuristicoEntity localTuristicoMod) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(
        @PathVariable long id) {
        return new ResponseEntity<>("Sucesso: ", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalTuristicoEntity> buscarPorId(
        @PathVariable long id) {
        return null;
    }

    @GetMapping("/{id}/visitas")
    public List<VisitacaoEntity> listarVisitas(
        @PathVariable long id) {
        return null;
    }
}