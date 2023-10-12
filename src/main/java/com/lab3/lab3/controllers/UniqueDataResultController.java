package com.lab3.lab3.controllers;

import com.lab3.lab3.repository.Task1Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unique_result")
public class UniqueDataResultController {

    private final Task1Repository task1Repository;

    public UniqueDataResultController(Task1Repository task1Repository) {
        this.task1Repository = task1Repository;
    }

    @GetMapping("/all")
    public ResponseEntity getAllData() {
        return ResponseEntity.ok(this.task1Repository.findAll());
    }
}
