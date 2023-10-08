package com.lab3.lab3;

import java.util.Scanner;


public class Task1
{
    public static void findPosition() {
        int[] numbers = {5, 10, 15, 20, 25};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для поиска: ");
        int target = scanner.nextInt();

        int position = findPositionRecursive(numbers, target, 0);
        if (position != -1) {
            System.out.println("Первый элемент, равный введенному числу, находится на позиции " + position);
        } else {
            System.out.println("Элемент, равный введенному числу, не найден в массиве");
        }
    }

    public static int findPositionRecursive(int[] numbers, int target, int index) {
        if (index >= numbers.length) {
            return -1; // Элемент не найден
        }
        if (numbers[index] == target) {
            return index; // Нашли элемент
        }
        // Рекурсивный вызов для следующего индекса
        return findPositionRecursive(numbers, target, index + 1);
    }
}
