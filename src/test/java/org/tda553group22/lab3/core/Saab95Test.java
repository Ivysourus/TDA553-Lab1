package org.tda553group22.lab3.core;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;
import org.tda553group22.lab3.math.Vector2;

class Saab95Test {
    private final Saab95 saab95 = new Saab95(new Vector2(0, 0));

    @Test
    void getNrDoors() {
        assertEquals(2, saab95.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(125.0, saab95.getEnginePower());
    }

    @Test
    void initialSpeedZero() {
        assertEquals(0.0, saab95.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.red, saab95.getColor());
    }

    @Test
    void startEngine() {
        saab95.startEngine();
        assertEquals(0.1, saab95.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        saab95.stopEngine();
        assertEquals(0.0, saab95.getCurrentSpeed());
    }

    @Test
    void checkTurboOn() {
        double oldSpeed = saab95.getCurrentSpeed();
        double amount = 1;
        saab95.setTurboOn();
        saab95.gas(amount);
        assertEquals(saab95.getCurrentSpeed(),
                Math.min(oldSpeed + saab95.getEnginePower() * 0.01 * 1.3 * amount, saab95.getEnginePower()));
    }

    @Test
    void checkTurboOff() {
        double oldSpeed = saab95.getCurrentSpeed();
        double amount = 1;
        saab95.setTurboOff();
        saab95.gas(amount);
        assertEquals(saab95.getCurrentSpeed(),
                Math.min(oldSpeed + saab95.getEnginePower() * 0.01 * 1 * amount, saab95.getEnginePower()));
    }

    @Test
    void incrementSpeed() {
        double amount = 1.0;
        double oldSpeed = saab95.getCurrentSpeed();
        saab95.gas(amount);
        assertEquals(saab95.getCurrentSpeed(),
                Math.min(oldSpeed + saab95.speedFactor() * amount, saab95.getEnginePower()));
    }

    @Test
    void decrementSpeed() {
        double amount = 1.0;
        double oldSpeed = saab95.getCurrentSpeed();
        saab95.brake(amount);
        assertEquals(saab95.getCurrentSpeed(), Math.max(oldSpeed - saab95.speedFactor() * amount, 0));
    }
}
