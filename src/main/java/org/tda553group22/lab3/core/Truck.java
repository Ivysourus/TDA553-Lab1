package org.tda553group22.lab3.core;

public abstract class Truck extends Car implements TruckBedFunctions {
    private TruckBedState truckBedState = new TruckBedRaised(this);

    /**
     * The angle of the truck bed, from 0-`maxBedAngle` degrees (in radians).
     */
    protected double bedAngle;

    /**
     * The max angle of the truck bed (in radians).
     */
    protected double maxBedAngle;

    protected void setTruckBedState(TruckBedState truckBedState) {
        assert truckBedState.getTruckHashCode() == this.hashCode() : "State has a different truck than this";
        this.truckBedState = truckBedState;
    }

    @Override
    public void raiseBed(double angle) {
        truckBedState.raiseBed(angle);
    }

    @Override
    public void lowerBed(double angle) {
        truckBedState.lowerBed(angle);
    }

    @Override
    public double getBedAngle() {
        return bedAngle;
    }
}
