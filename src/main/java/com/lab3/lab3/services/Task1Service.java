package com.lab3.lab3.services;

import com.lab3.lab3.models.Task1;
import com.lab3.lab3.repository.Task1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task1Service {
    @Autowired
    private Task1Repository task1Repository;

    public int findAndSaveUniqueValue(int number) {
        // Проверяем, существует ли значение в базе данных
        Task1 existingValue = task1Repository.findByUniqueValue(Integer.toString(number));
        if (existingValue != null) {
            return -1; // Если значение уже существует, возвращаем -1
        } else {
            // Если значение не существует, создаем новый экземпляр и сохраняем его
            Task1 newTask1 = new Task1();
            newTask1.setUniqueValue(Integer.toString(number));
            task1Repository.save(newTask1);
            return number;
        }
    }
}
