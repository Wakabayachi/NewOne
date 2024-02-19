package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        System.out.println("Numbers in the array:");
        IntStream.range(0, numbers.length)
                .map(index -> numbers[index])
                .forEach(System.out::println);

        double average = IntStream.range(0, numbers.length)
                .map(index -> numbers[index])
                .average()
                .orElse(0);

        return average;
    }
}