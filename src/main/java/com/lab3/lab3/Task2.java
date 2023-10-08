package com.lab3.lab3;

import java.util.Scanner;

public class Task2 {


    public static void findCombinations() {
        int[] numbers = {2, 4, 6, 8, 10};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целевую сумму: ");
        int targetSum = scanner.nextInt();

        System.out.println("Комбинации, дающие сумму " + targetSum + ":");
        findAndPrintCombinations(numbers, targetSum);
    }

    public static int findAndPrintCombinations(int[] numbers, int targetSum) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == targetSum) {
                    System.out.println(numbers[i] + " + " + numbers[j] + " = " + targetSum);
                    count++;
                }
            }
        }

        return count;
    }



}