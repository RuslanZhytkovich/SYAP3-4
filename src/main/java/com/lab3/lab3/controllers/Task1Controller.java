package com.lab3.lab3.controllers;

import com.lab3.lab3.models.Task1;
import com.lab3.lab3.request.NumberPositionRequest;
import com.lab3.lab3.services.Task1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Task1Controller {
    @Autowired
    private Task1Service task1Service;

    @PostMapping("/findPositionInTask1")
    public ResponseEntity<Map<String, Object>> findPosition(@RequestBody NumberPositionRequest request) {
        int number = request.getNumber();

        long startTime = System.currentTimeMillis();
        int position = task1Service.findAndSaveUniqueValue(number);
        long endTime = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("result", position == -1 ? "не найдено" : "найдено на позиции: " + position);
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
