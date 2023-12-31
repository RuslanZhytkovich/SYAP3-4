package com.lab3.lab3.controllers;

import com.lab3.lab3.models.RequestHistory;
import com.lab3.lab3.repository.RequestHistoryRepository;
import com.lab3.lab3.repository.Task1Repository;
import com.lab3.lab3.request.Task2Request;
import com.lab3.lab3.services.Task2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Task2Controller {
    @Autowired
    private Task2Service service;
    @Autowired
    private RequestHistoryRepository requestHistoryRepository;

    @Autowired
    private Task1Repository task1Repository;




    @PostMapping("/findSum")
    public ResponseEntity<Map<String, Object>> findSum(@RequestBody Task2Request request) {
        int sum = request.getSum();
        int[] numbers = request.getNumbers();

        long startTime = System.currentTimeMillis();
        List<String> combinations = service.findCombinations(sum, numbers);
        long endTime = System.currentTimeMillis();


        RequestHistory requestHistory = new RequestHistory();
        requestHistory.setRequestTime(formatTime(startTime));
        requestHistory.setResponseTime(formatTime(endTime));
        requestHistory.setExecutionTime(endTime - startTime);


        Map<String, Object> response = new HashMap<>();
        response.put("result", combinations.isEmpty() ? "не найдено" : "найдено комбинаций: " + combinations);
        response.put("startTime", formatTime(startTime));
        response.put("endTime", formatTime(endTime));
        response.put("executionTime", endTime - startTime);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    private String formatTime(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(time));
    }
}