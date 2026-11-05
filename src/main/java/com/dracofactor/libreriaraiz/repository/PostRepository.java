package com.dracofactor.libreriaraiz.repository;

import com.dracofactor.libreriaraiz.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> { }