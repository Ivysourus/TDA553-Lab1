package org.tda553group22.lab3.core;

class EngineVehicleStopped implements EngineVehicleState {
    private final EngineVehicle engineVehicle;

    public EngineVehicleStopped(EngineVehicle engineVehicle) {
        this.engineVehicle = engineVehicle;
    }

    @Override
    public void startEngine() {
        engineVehicle.currentSpeed = 0.1;
        engineVehicle.setEngineVehicleState(new EngineVehicleMoving(engineVehicle));
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
