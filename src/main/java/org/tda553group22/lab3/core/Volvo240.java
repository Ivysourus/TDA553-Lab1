package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

import java.awt.Color;

class Volvo240 extends PersonCar {
    private final static double trimFactor = 1.25; // Engine power of the car

    public Volvo240(Vector2 pos) {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        this.pos = pos;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
