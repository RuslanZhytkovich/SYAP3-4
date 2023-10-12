package com.lab3.lab3.services;
import com.lab3.lab3.models.Task1;

import com.lab3.lab3.repository.Task1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberPositionService {
    @Autowired
    private Task1Repository task1Repository;

    public int findPosition(int number) {
        String uniqueValue = Integer.toString(number);
        Task1 existingValue = task1Repository.findByUniqueValue(uniqueValue);

        if (existingValue == null) {
            Task1 newTask1 = new Task1();
            newTask1.setUniqueValue(uniqueValue);
            task1Repository.save(newTask1);
        }

        int[] numbers = {5, 10, 15, 20, 25};
        int position = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                position = i;
                break;
            }
        }

        return position;
    }
}

