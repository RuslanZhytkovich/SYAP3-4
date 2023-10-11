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
        int[] numbers = {5, 10, 15, 20, 25};
        int position = -1; // Устанавливаем значение -1 по умолчанию

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                position = i;
                break;
            }
        }

        return position;
    }
}