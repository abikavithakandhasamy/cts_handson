package com.cts;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // Optional main method (only if you want to run Calculator.java)
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Addition: " + calculator.add(10, 20));
        System.out.println("Multiplication: " + calculator.multiply(5, 4));
    }
}