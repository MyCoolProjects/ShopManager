package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultPageController {

    @GetMapping(path = {"/home/**","/product/**","/catalog/**"})
    public String defaultPage() {
        return "/app.html";
    }
    @GetMapping(path = "/")
    public String homePage() {
        return "redirect:/home/";
    }

}
