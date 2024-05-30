package com.projet.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String login() {
        return "login"; 
    }
    @GetMapping("/home")
    public String home() {
        return "index"; 
    }
    @GetMapping("/index")
    public String acceuil() {
        return "index"; 
    }
    
}
