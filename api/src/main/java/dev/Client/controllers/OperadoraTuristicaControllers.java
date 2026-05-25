package dev.Client.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;





@RestController

public class OperadoraTuristicaControllers {
    @RequestMapping("operadoras")
    
    // Create new OperadoraTuristica
    @PostMapping("/")
    public String postOperadoraTuristicaById(@RequestBody String entity) {
        
        return new String("Create New Operadra");
    }
    // Put Operadora
    @PutMapping("/{id}")
    public String putOperadoraTuristicaById(@PathVariable String id, @RequestBody String entity) {
        return entity;
    }
    // Get information by id
    @GetMapping("/{id}")
    public String getOperadoraTuristicaById(@RequestParam String param) {
        return new String("get information");
    }
    
 
    
}
