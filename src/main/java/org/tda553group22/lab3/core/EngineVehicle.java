package org.tda553group22.lab3.core;

public abstract class EngineVehicle extends Vehicle {
    protected double enginePower;
    protected EngineVehicleState state;

    public void setState(EngineVehicleState state){
        this.state = state;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        state.startEngine(this);
    }

    public void stopEngine() {
        state.stopEngine(this);
    }

    public void gas(double amount) {
        state.gas(this, amount);
    }

    public void brake(double amount) {
        state.brake(this, amount);
    }

    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    abstract protected double speedFactor();
}
