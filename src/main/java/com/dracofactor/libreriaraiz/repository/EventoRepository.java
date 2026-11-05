package com.dracofactor.libreriaraiz.repository;

import com.dracofactor.libreriaraiz.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> { }