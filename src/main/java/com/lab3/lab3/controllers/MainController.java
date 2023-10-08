package com.lab3.lab3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("title", "Главная страница");
        return "index";
    }

    @GetMapping("/requests_history")
    public String requests_history(Model model)
    {
        return "requests_history";
    }

    @GetMapping("/task1")
    public String task1(Model model)
    {
        return "task1";
    }

    @GetMapping("/task2")
    public String task2(Model model)
    {
        return "task2";
    }





}
