package dev.Instituicao.Controllers;
import dev.Instituicao.Entity.*;
import dev.Instituicao.Services.OperadoraTuristicaService;

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
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/operadoras")

public class OperadoraTuristicaControllers {
    private final OperadoraTuristicaService serviceOperadora;

    @Autowired
    public OperadoraTuristicaControllers(OperadoraTuristicaService serviceOperadora) {
        this.serviceOperadora = serviceOperadora;
    }
    
    // Create new OperadoraTuristica
    @PostMapping("/")
    public ResponseEntity<String> postOperadoraTuristicaById(@RequestBody OperadoraTuristicaEntity Operadora_) { 
        String returnValue = serviceOperadora.CreateOperadoraTuristica(Operadora_);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    // Put Operadora
    @PutMapping("/{id}")
    public ResponseEntity<String> putOperadoraTuristicaById(@PathVariable long id, @RequestBody OperadoraTuristicaEntity Operadora_) {
        String returnValue = serviceOperadora.UpdateOperadoraTuristicaById(Operadora_, id);
        return new ResponseEntity<>(returnValue, HttpStatus.NO_CONTENT);
    }
    // Get information by id
    @GetMapping("/{login}")
    public ResponseEntity<OperadoraTuristicaEntity> getOperadoraTuristicaById(@PathVariable String login) {
        return new ResponseEntity<>( serviceOperadora.ReadOperadoraTuristicaByLogin(login), HttpStatus.OK);
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOperadoraTuristicaById(@PathVariable Long id) {
    String returnValue = serviceOperadora.DeleteOperadoraTuristicaById(id);
    return new ResponseEntity<>(
            returnValue,
            HttpStatus.NO_CONTENT
    );
}
    

 
    
}
