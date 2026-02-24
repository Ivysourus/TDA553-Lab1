package org.tda553group22.lab3.main;

public class CarFactory {
    public Car createVolvo240() {
        return new Volvo240();
    }

    public Car createSaab95() {
        return new Saab95();
    }

    public Car createScania() {
        return new Scania();
    }
}
