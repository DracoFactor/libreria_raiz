package com.dracofactor.libreriaraiz.controller;

import com.dracofactor.libreriaraiz.model.Evento;
import com.dracofactor.libreriaraiz.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calendario")
@RequiredArgsConstructor
public class CalendarioController {

    private final EventoRepository eventoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("eventos", eventoRepository.findAll());
        return "calendario";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("evento", new Evento());
        return "calendario-form";
    }

    @PostMapping
    public String guardar(@ModelAttribute Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/calendario";
    }
}