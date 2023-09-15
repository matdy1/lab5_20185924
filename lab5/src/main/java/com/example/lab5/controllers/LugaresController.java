package com.example.lab5.controllers;

import com.example.lab5.repository.LugaresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LugaresController {

    final LugaresRepository lugaresRepository;

    public LugaresController(LugaresRepository lugaresRepository) {
        this.lugaresRepository = lugaresRepository;
    }


    @GetMapping(value="/lugares")
    public String listaLugares(Model model){

        model.addAttribute("lista", lugaresRepository.findAll());

        return "listaLugares";
    }
}
