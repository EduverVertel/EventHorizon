package com.eventhorizon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pruebaController {

    @GetMapping("/")
    public String inicio() {
        return "¡EventHorizon está funcionando!";
    }
}