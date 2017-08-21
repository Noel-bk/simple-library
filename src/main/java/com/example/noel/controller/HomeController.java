package com.example.noel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/")
public class HomeController {

    @GetMapping
    public String index() {
        return "index";
    }
}
