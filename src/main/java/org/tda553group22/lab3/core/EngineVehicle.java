package org.tda553group22.lab3.core;

public abstract class EngineVehicle extends Vehicle {
    protected double enginePower;
    private EngineVehicleState engineVehicleState = new EngineVehicleStopped(this);

    protected void setEngineVehicleState(EngineVehicleState engineVehicleState) {
        assert engineVehicleState.getEngineVehicleHashCode() == this.hashCode() : "State has a different engineVehicle than this";
        this.engineVehicleState = engineVehicleState;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        engineVehicleState.startEngine();
    }

    public void stopEngine() {
        engineVehicleState.stopEngine();
    }

    public void gas(double amount) {
        engineVehicleState.gas(amount);
    }

    public void brake(double amount) {
        engineVehicleState.brake(amount);
    }

    @Override
    public void move() {
        engineVehicleState.move();
    }

    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    abstract protected double speedFactor();
}
