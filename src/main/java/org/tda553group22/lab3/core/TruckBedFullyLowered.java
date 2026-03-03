package org.tda553group22.lab3.core;

class TruckBedFullyLowered implements TruckBedState {
    private final Truck truck;

    public TruckBedFullyLowered(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void raiseBed(double angle) {
        assert angle > 0 : "Angle cannot be negative or zero";
        truck.bedAngle = Math.min(truck.bedAngle + angle, truck.maxBedAngle);
        truck.setTruckBedState(new TruckBedPartiallyLowered(truck));
    }

    @Override
    public void lowerBed(double angle) {
    }

    @Override
    public int getTruckHashCode() {
        return truck.hashCode();
    }
}
