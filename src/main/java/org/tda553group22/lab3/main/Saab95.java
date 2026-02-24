package org.tda553group22.lab3.main;

import org.tda553group22.lab3.math.Vector2;

import java.awt.Color;

public class Saab95 extends PersonCar {
    private boolean turboOn;

    public Saab95(Vector2 pos) {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        this.pos = pos;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
