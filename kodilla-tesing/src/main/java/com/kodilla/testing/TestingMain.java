// com.kodilla.testing.TestingMain.java

package com.kodilla.testing;

import com.kodilla.testing.calculator.calculator;

public class TestingMain {
    public static void main(String[] args) {
        calculator calculator = new calculator();

        // Test for add method
        int resultAdd = calculator.add(3, 7);
        if (resultAdd == 10) {
            System.out.println("Add method test: OK");
        } else {
            System.out.println("Add method test: Error!");
        }

        // Test for subtract method
        int resultSubtract = calculator.subtract(10, 5);
        if (resultSubtract == 5) {
            System.out.println("Subtract method test: OK");
        } else {
            System.out.println("Subtract method test: Error!");
        }
    }
}
