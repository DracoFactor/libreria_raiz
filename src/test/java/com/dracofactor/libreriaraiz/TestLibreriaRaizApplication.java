package com.dracofactor.libreriaraiz;

import org.springframework.boot.SpringApplication;

public class TestLibreriaRaizApplication {

    public static void main(String[] args) {
        SpringApplication.from(LibreriaRaizApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
