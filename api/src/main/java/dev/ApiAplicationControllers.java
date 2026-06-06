package dev;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiAplicationControllers {
    @GetMapping("/")
    public String getMethodName() {
        return new String("Passly esta rodando em produção...");
    }
    
}
