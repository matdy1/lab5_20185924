package com.example.lab5.controllers;

import com.example.lab5.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViajesController {

    final ViajesRepository ViajesRepository;

    public ViajesController(com.example.lab5.repository.ViajesRepository viajesRepository) {
        ViajesRepository = viajesRepository;
    }


    @GetMapping(value="/viajes")
    public String listaJugadores (Model model){

        model.addAttribute("lista", ViajesRepository.findAll());

        return "listaViajes";
    }
}
