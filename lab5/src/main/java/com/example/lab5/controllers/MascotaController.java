package com.example.lab5.controllers;

import com.example.lab5.repository.MascotasRepository;
import com.example.lab5.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MascotaController {

    final MascotasRepository mascotasRepository;

    public MascotaController(MascotasRepository mascotasRepository) {
        this.mascotasRepository = mascotasRepository;
    }

    @GetMapping(value="/mascotas")
    public String listaMascotas (Model model){

        model.addAttribute("lista", mascotasRepository.findAll());

        return "listaMascotas";
    }
}
