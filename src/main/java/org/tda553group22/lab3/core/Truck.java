package org.tda553group22.lab3.core;

public abstract class Truck extends Car implements TruckBedFunctions {
    /**
     * The angle of the truck bed, from 0-`maxBedAngle` degrees (in radians).
     */
    protected double bedAngle;

    /**
     * The max angle of the truck bed (in radians).
     */
    protected double maxBedAngle;

    @Override
    public void raiseBed(double angle) {
        assert angle >= 0 : "Angle cannot be negative";
        bedAngle = Math.min(bedAngle + angle, maxBedAngle);
    }

    @Override
    public void lowerBed(double angle) {
        assert angle >= 0 : "Angle cannot be negative";
        bedAngle = Math.max(0, bedAngle - angle);
    }

    @Override
    public double getBedAngle() {
        return bedAngle;
    }
}
