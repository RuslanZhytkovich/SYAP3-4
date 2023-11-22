package com.lab3.lab3.controllers;
import com.lab3.lab3.models.RequestHistory;
import com.lab3.lab3.models.Task1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lab3.lab3.repository.Task1Repository;
import java.util.List;


@Controller
public class MainController {

    private final Task1Repository task1Repository;

    public MainController(Task1Repository task1Repository) {
        this.task1Repository = task1Repository;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("title", "Главная страница");
        return "index";
    }


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
