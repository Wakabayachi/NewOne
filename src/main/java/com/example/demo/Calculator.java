package com.example.demo;


    class Calculator {
        // Metoda dodawania
        public static int add(int a, int b) {
            return a + b;
        }

        // Metoda odejmowania
        public static int subtract(int a, int b) {
            return a - b;
        }

        public static void main(String[] args) {
            // Przykładowe użycie klasy Calculator
            int resultAdd = Calculator.add(5, 3);
            int resultSubtract = Calculator.subtract(10, 4);

            System.out.println("Wynik dodawania: " + resultAdd);
            System.out.println("Wynik odejmowania: " + resultSubtract);
        }
    }
