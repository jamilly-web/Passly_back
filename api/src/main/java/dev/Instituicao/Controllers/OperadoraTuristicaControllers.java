package dev.Instituicao.Controllers;
import dev.Instituicao.Entity.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/operadoras")

public class OperadoraTuristicaControllers {
    // Create new OperadoraTuristica
    @PostMapping("/")
    public ResponseEntity<String> postOperadoraTuristicaById(@RequestBody OperadoraTuristicaEntity Operadora_) { 
        return new ResponseEntity<>("Sucesso", HttpStatus.OK);
    }
    // Put Operadora
    @PutMapping("/{id}")
    public ResponseEntity<String> putOperadoraTuristicaById(@PathVariable long id, @RequestBody OperadoraTuristicaEntity Operadora_) {
        return new ResponseEntity<>("Sucess", HttpStatus.NO_CONTENT);
    }
    // Get information by id
    @GetMapping("/{id}")
    public ResponseEntity<OperadoraTuristicaEntity> getOperadoraTuristicaById(@PathVariable long id) {
       
        OperadoraTuristicaEntity operadoraTuristicaEntity = new OperadoraTuristicaEntity("", "", "", "", "", null);
        return new ResponseEntity<>(operadoraTuristicaEntity, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOperadoraTuristicaById(@PathVariable Long id) {

    return new ResponseEntity<>(
            "Sucess",
            HttpStatus.NO_CONTENT
    );
}
    
 
    
}
