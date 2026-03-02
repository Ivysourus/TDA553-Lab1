package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

import java.awt.Color;

class Scania extends Truck {
    public Scania(Vector2 pos) {
        nrDoors = 2;
        color = Color.white;
        modelName = "2021 Scania R410 A6X2NA Yak Edition";
        enginePower = 100;
        maxBedAngle = (7.0 / 18.0) * Math.PI;
        this.pos = pos;
        state = new EngineVehicleStopped();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
