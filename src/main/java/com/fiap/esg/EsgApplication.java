package com.fiap.esg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsgApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Aplicação Cidades ESG inteligentes está rodando com sucesso!";
    }
}