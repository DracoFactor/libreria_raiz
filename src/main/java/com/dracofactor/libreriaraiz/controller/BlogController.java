package com.dracofactor.libreriaraiz.controller;

import com.dracofactor.libreriaraiz.model.Post;
import com.dracofactor.libreriaraiz.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final PostRepository postRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "blog";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("post", new Post());
        return "blog-form";
    }

    @PostMapping
    public String guardar(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/blog";
    }
}