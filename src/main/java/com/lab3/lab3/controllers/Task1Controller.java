package com.lab3.lab3.controllers;
import com.lab3.lab3.models.RequestHistory;
import com.lab3.lab3.models.Task1;
import com.lab3.lab3.repository.RequestHistoryRepository;
import com.lab3.lab3.repository.Task1Repository;
import com.lab3.lab3.request.Task1Request;
import com.lab3.lab3.services.Task1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.text.SimpleDateFormat;

@RestController
public class Task1Controller {
    @Autowired
    private Task1Service service;
    @Autowired
    private RequestHistoryRepository requestHistoryRepository;

    @Autowired
    private Task1Repository task1Repository;




    @PostMapping("/findPosition")
    public ResponseEntity<Map<String, Object>> findPosition(@RequestBody Task1Request request) {
        int number = request.getNumber();
        int[] numbers = request.getNumbers();

        long startTime = System.currentTimeMillis();
        int position = service.findPosition(number, numbers);
        long endTime = System.currentTimeMillis();

        // Создаем запись в RequestHistory и сохраняем её
        RequestHistory requestHistory = new RequestHistory();
        requestHistory.setRequestTime(formatTime(startTime));
        requestHistory.setResponseTime(formatTime(endTime));
        requestHistory.setExecutionTime(endTime - startTime);

        requestHistoryRepository.save(requestHistory);

        // Проверяем, существует ли значение в Task1
        Task1 existingValue = task1Repository.findByUniqueValue(Integer.toString(position));

        if (existingValue == null) {
            // Если значение не существует, создаем новый экземпляр и сохраняем его в Task1
            Task1 newTask1 = new Task1();
            newTask1.setUniqueValue(Integer.toString(position));
            task1Repository.save(newTask1);
        }

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
