package com.mycoolprojects.shopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultPageController {

    @GetMapping({"/","/product/**","/catalog/**"})
    public String defaultPage() {
        return "/app.html";
    }
}