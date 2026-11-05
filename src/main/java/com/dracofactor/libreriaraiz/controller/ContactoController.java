package com.dracofactor.libreriaraiz.controller;

import com.dracofactor.libreriaraiz.model.MensajeContacto;
import com.dracofactor.libreriaraiz.repository.MensajeContactoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacto")
@RequiredArgsConstructor
public class ContactoController {

    private final MensajeContactoRepository mensajeRepository;

    @GetMapping
    public String formulario(Model model) {
        model.addAttribute("mensajeContacto", new MensajeContacto());
        return "contacto";
    }

    @PostMapping
    public String enviar(@Valid @ModelAttribute("mensajeContacto") MensajeContacto mensaje,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contacto";
        }
        mensajeRepository.save(mensaje);
        model.addAttribute("exito", "¡Gracias por escribirnos! Te responderemos pronto.");
        model.addAttribute("mensajeContacto", new MensajeContacto());
        return "contacto";
    }
}