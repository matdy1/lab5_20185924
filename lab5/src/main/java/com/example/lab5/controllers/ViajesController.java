package com.example.lab5.controllers;

import com.example.lab5.entity.Viajes;
import com.example.lab5.repository.LugaresRepository;
import com.example.lab5.repository.MascotasRepository;
import com.example.lab5.repository.PersonaRepository;
import com.example.lab5.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ViajesController {

    final ViajesRepository ViajesRepository;
    final MascotasRepository mascotasRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    public ViajesController(com.example.lab5.repository.ViajesRepository viajesRepository, MascotasRepository mascotasRepository, PersonaRepository personaRepository, LugaresRepository lugaresRepository) {
        ViajesRepository = viajesRepository;
        this.mascotasRepository = mascotasRepository;
        this.personaRepository = personaRepository;
        this.lugaresRepository = lugaresRepository;
    }


    @GetMapping(value="/viajes")
    public String listaJugadores (Model model){

        model.addAttribute("lista", ViajesRepository.findAll());

        return "listaViajes";
    }

    @GetMapping("/nuevoViaje")
    public String crearViaje( ) {

        return "nuevoViaje";
    }

    @GetMapping("/borrar")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Viajes> optShipper = ViajesRepository.findById(id);

        if (optShipper.isPresent()) {
            ViajesRepository.deleteById(id);
        }
        return "redirect:/viajes";

    }

    @GetMapping("/editar")
    public String editarTransportista(Model model,
                                      @RequestParam("id") int id) {

        Optional<Viajes> optShipper = ViajesRepository.findById(id);

        if (optShipper.isPresent()) {
            Viajes viajes = optShipper.get();
            model.addAttribute("viaje", viajes);
            return "editarViaje";
        } else {
            return "redirect:/viajes";
        }
    }

    @PostMapping("/actualizar")
    public String guardarNuevoTransportista(Viajes viajes, @RequestParam("lugar") String lugar,@RequestParam("persona") String persona){
        ViajesRepository.save(viajes);
        return "redirect:/viajes";
    }

    @GetMapping("/nuevo")
    public String nuevoTransportistaFrm(Model model) {
        model.addAttribute("lista", lugaresRepository.findAll());
        model.addAttribute("lista1", personaRepository.findAll());
        return "nuevoViaje";
    }


}
