package com.lab3.lab3.services;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class Task2Service {

    public List<String> findCombinations(int sum, int[] numbers) {
        System.out.println("Комбинации, дающие сумму " + sum + ":");
        return findAndReturnCombinations(numbers, sum);
    }

    private List<String> findAndReturnCombinations(int[] numbers, int sum) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    result.add(numbers[i] + " + " + numbers[j] + " = " + sum);
                }
            }
        }

        return result;
    }
}