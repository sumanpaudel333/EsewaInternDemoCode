package org.example;

public class SimpleInterestCalculator {
    public float calculateSimpleInterest(float principal, float time, float rate) {
        if (principal <= 0 || time <= 0 || rate <= 0)
            throw new IllegalArgumentException("Invalid Input");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (principal * time * rate) / 100f;
    }
}
