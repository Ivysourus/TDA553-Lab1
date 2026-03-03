package org.tda553group22.lab3.core;

class EngineVehicleLocked implements EngineVehicleState {
    private final EngineVehicle engineVehicle;

    public EngineVehicleLocked(EngineVehicle engineVehicle) {
        this.engineVehicle = engineVehicle;
    }

    @Override
    public void startEngine() {
    }

    @Override
    public void stopEngine() {
    }

    @Override
    public void gas(double amount) {
    }

    @Override
    public void brake(double amount) {
    }

    @Override
    public void move() {
    }

    @Override
    public int getEngineVehicleHashCode() {
        return engineVehicle.hashCode();
    }
}
