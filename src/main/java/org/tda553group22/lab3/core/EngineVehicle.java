package org.tda553group22.lab3.core;

public abstract class EngineVehicle extends Vehicle {
    protected double enginePower;
    private EngineVehicleState state = new EngineVehicleStopped(this);

    protected void setState(EngineVehicleState state) {
        assert state.getEngineVehicleHashCode() == this.hashCode() : "State has a different engineVehicle than this";
        this.state = state;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        state.startEngine();
    }

    public void stopEngine() {
        state.stopEngine();
    }

    public void gas(double amount) {
        state.gas(amount);
    }

    public void brake(double amount) {
        state.brake(amount);
    }

    @Override
    public void move() {
        state.move();
    }

    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    abstract protected double speedFactor();
}
