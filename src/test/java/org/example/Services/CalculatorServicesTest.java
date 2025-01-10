package org.example.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServicesTest {

    CalculatorServices calculator = new CalculatorServices();

    @Test
    public void testAddTwoNumbers() {
        double result = calculator.add(10, 5);
        Assertions.assertEquals(15, result, "Addition of two numbers failed");
    }

    @Test
    public void testAddMultipleNumbers() {
        double result = calculator.add(10, 5, 15, 20);
        Assertions.assertEquals(50, result, "Addition of multiple numbers failed");
    }

    @Test
    public void testSubtract() {
        double result = calculator.subtract(10, 5);
        Assertions.assertEquals(5, result, "Subtraction failed");
    }

    @Test
    public void testMultiply() {
        double result = calculator.multiply(10, 5);
        Assertions.assertEquals(50, result, "Multiplication failed");
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(10, 5);
        Assertions.assertEquals(2, result, "Division failed");
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        }, "Division by zero did not throw an exception");
    }
}