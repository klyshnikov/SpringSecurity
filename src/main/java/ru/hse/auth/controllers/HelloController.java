package ru.hse.auth.controllers;

import jakarta.annotation.security.DenyAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-all")
    public String helloAll() {
        return "Hello, all!";
    }

    @GetMapping("/hello-user")
    public String helloUser() {
        return "Hello, user!";
    }

    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "Hello, admin!";
    }
}
