package com.lab3.lab3.controllers;

import com.lab3.lab3.models.RequestHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lab3.lab3.repository.RequestHistoryRepository; // Здесь должен быть правильный путь к вашему репозиторию

@Controller
public class MainController {



    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("title", "Главная страница");
        return "index";
    }

    @Autowired
    private RequestHistoryRepository requestHistoryRepository;

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("history", new RequestHistory());
        return "history";
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
