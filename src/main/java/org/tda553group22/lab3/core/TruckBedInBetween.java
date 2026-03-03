package org.tda553group22.lab3.core;

class TruckBedInBetween implements TruckBedState {
    private final Truck truck;

    public TruckBedInBetween(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void raiseBed(double angle) {
        assert angle > 0 : "Angle cannot be negative or zero";
        truck.bedAngle = Math.min(truck.bedAngle + angle, truck.maxBedAngle);
        if (truck.bedAngle == truck.maxBedAngle) {
            truck.setTruckBedState(new TruckBedRaised(truck));
            truck.setEngineVehicleState(new EngineVehicleStopped(truck));
        }
    }

    @Override
    public void lowerBed(double angle) {
        assert angle > 0 : "Angle cannot be negative or zero";
        truck.bedAngle = Math.max(0, truck.bedAngle - angle);
        if (truck.bedAngle == 0) {
            truck.setTruckBedState(new TruckBedLowered(truck));
        }
    }

    @Override
    public int getTruckHashCode() {
        return truck.hashCode();
    }
}
