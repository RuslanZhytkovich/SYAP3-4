package com.lab3.lab3.controllers;

import com.lab3.lab3.repository.Task1Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab3.lab3.repository.RequestHistoryRepository;


@RestController
@RequestMapping("/request_history")
public class RequestHistoryController {

    private final RequestHistoryRepository requestHistoryRepository;

    public RequestHistoryController(RequestHistoryRepository requestHistoryRepository) {
        this.requestHistoryRepository = requestHistoryRepository;
    }

    @GetMapping("/all")
    public ResponseEntity getAllHistories()
    {
        return ResponseEntity.ok(this.requestHistoryRepository.findAll());
    }
}


