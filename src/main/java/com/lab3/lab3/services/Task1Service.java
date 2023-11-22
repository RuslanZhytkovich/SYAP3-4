package com.lab3.lab3.services;
import com.lab3.lab3.models.Task1;

import com.lab3.lab3.repository.Task1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task1Service {
    @Autowired
    private Task1Repository task1Repository;

    public int findPosition(int number, int[] numbers) {
        System.out.println(numbers);
        String uniqueValue = Integer.toString(number);
        Task1 existingValue = task1Repository.findByUniqueValue(uniqueValue);

        if (existingValue == null) {
            Task1 newTask1 = new Task1();
            newTask1.setUniqueValue(uniqueValue);
            task1Repository.save(newTask1);
        }

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


