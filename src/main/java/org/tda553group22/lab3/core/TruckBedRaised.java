package org.tda553group22.lab3.core;

class TruckBedRaised implements TruckBedState {
    private final Truck truck;

    public TruckBedRaised(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void raiseBed(double angle) {
    }

    @Override
    public void lowerBed(double angle) {
        assert angle > 0 : "Angle cannot be negative or zero";
        if (truck.currentSpeed != 0) {
            return;
        }
        truck.bedAngle = Math.max(0, truck.bedAngle - angle);
        truck.setTruckBedState(new TruckBedInBetween(truck));
        truck.setEngineVehicleState(new EngineVehicleLocked(truck));
    }

    @Override
    public int getTruckHashCode() {
        return truck.hashCode();
    }
}
