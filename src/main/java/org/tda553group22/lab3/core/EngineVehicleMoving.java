package org.tda553group22.lab3.core;

public class EngineVehicleMoving implements EngineVehicleState {
    @Override
    public void startEngine(EngineVehicle vehicle){
        // Do nothing
    }

    @Override
    public void stopEngine(EngineVehicle vehicle){
        vehicle.currentSpeed = 0;
        vehicle.state = new EngineVehicleStopped();
    }

    /**
     * Increases the speed of the vehicle.
     *
     * @param amount The amount to speed up by in the range [0,1].
     */
    @Override
    public void gas(EngineVehicle vehicle, double amount){
        assert amount >= 0.0 && amount <= 1.0 : "Variable `amount` outside the range [0,1]";
        vehicle.incrementSpeed(amount);
    }

    /**
     * Decreases the speed of the vehicle.
     *
     * @param amount The amount to slow down by in the range [0,1].
     */
    @Override
    public void brake(EngineVehicle vehicle, double amount){
        assert amount >= 0.0 && amount <= 1.0 : "Variable `amount` outside the range [0,1]";
        vehicle.decrementSpeed(amount);
        if (vehicle.getCurrentSpeed() <= 0) {
            vehicle.state = new EngineVehicleStopped();
        }
    }
}
