package org.tda553group22.lab3.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScaniaTest {
    private final Scania scania = new Scania();

    @Test
    void raiseBedAtZero() {
        double initial = scania.getBedAngle();
        double angle = 0.1 * Math.PI;
        scania.raiseBed(angle);
        assertEquals(initial + angle, scania.getBedAngle());
    }

    @Test
    void lowerBedAtZero() {
        double angle = 0.1 * Math.PI;
        scania.lowerBed(angle);
        assertEquals(0, scania.getBedAngle());
    }

    @Test
    void raiseBedMaxLimit() {
        double angle = 2.0 * Math.PI;
        scania.raiseBed(angle);
        assertEquals((7.0 / 18.0) * Math.PI, scania.getBedAngle());
    }
}
