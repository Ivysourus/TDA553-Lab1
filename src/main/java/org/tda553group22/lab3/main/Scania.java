package org.tda553group22.lab3.main;

import java.awt.Color;

public class Scania extends Truck {
    public Scania() {
        nrDoors = 2;
        color = Color.white;
        modelName = "2021 Scania R410 A6X2NA Yak Edition";
        enginePower = 100;
        maxBedAngle = (7.0 / 18.0) * Math.PI;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
