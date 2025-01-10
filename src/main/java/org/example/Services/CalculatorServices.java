package org.example.Services;
public class CalculatorServices {

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for addition with multiple numbers
    public double add(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}