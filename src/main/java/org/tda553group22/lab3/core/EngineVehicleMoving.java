package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

class EngineVehicleMoving implements EngineVehicleState {
    private final EngineVehicle engineVehicle;

    public EngineVehicleMoving(EngineVehicle engineVehicle) {
        this.engineVehicle = engineVehicle;
    }

    @Override
    public void startEngine() {
    }

    @Override
    public void stopEngine() {
        engineVehicle.currentSpeed = 0;
        engineVehicle.setState(new EngineVehicleStopped(engineVehicle));
    }

    /**
     * Increases the speed of the engineVehicle.
     *
     * @param amount The amount to speed up by in the range [0,1]
     */
    @Override
    public void gas(double amount) {
        assert amount >= 0.0 && amount <= 1.0 : "Variable `amount` outside the range [0,1]";
        engineVehicle.incrementSpeed(amount);
    }

    /**
     * Decreases the speed of the engineVehicle.
     *
     * @param amount The amount to slow down by in the range [0,1]
     */
    @Override
    public void brake(double amount) {
        assert amount >= 0.0 && amount <= 1.0 : "Variable `amount` outside the range [0,1]";
        engineVehicle.decrementSpeed(amount);
        if (engineVehicle.getCurrentSpeed() == 0) {
            engineVehicle.setState(new EngineVehicleStopped(engineVehicle));
        }
    }

    @Override
    public void move() {
        engineVehicle.pos = engineVehicle.pos.add(Vector2.fromPolar(engineVehicle.getCurrentSpeed(), engineVehicle.getAngle()));
    }

    @Override
    public int getEngineVehicleHashCode() {
        return engineVehicle.hashCode();
    }
}
