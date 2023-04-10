package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TestSimpleInterestCalculator {
    @Test
    public void testSimpleInterestCalculatorWithSmallNumbers() {
        SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
        float actual = simpleInterestCalculator.calculateSimpleInterest(20000, 5, 8);
        float expected = 8000.0f; //through manual Calculation
        assertEquals(expected, actual,"Maybe results are not matching");
    }
    @Test
    public void testSimpleInterestCalculatorWithBigNumbers() {
        SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
        float actual = simpleInterestCalculator.calculateSimpleInterest(2000000, 10, 13);
        float expected = 2600000.12f; //through manual Calculation
        assertEquals(expected, actual,"Maybe results are not matching");
        //assertEquals(expected, actual,0.5,"Maybe results are not matching");
        // here 0.5 is delta value which is the difference that is allowing the result
    }
    @Test
    public void testSimpleInterestCalculatorWithInvalidInputs() {
        SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
        assertThrows(IllegalArgumentException.class,()-> simpleInterestCalculator.calculateSimpleInterest(0,0,0));
    }
    @Test
    public void testSimpleInterestCalculatorWithTimer() {
        SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
        assertTimeout(Duration.ofMillis(2000),()->{
            simpleInterestCalculator.calculateSimpleInterest(10000,4,10);
        });
    }
}
