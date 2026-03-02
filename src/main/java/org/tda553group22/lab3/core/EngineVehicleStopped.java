package org.tda553group22.lab3.core;

public class EngineVehicleStopped implements EngineVehicleState {
    @Override
    public void startEngine(EngineVehicle vehicle){
        vehicle.currentSpeed = 0.1;
        vehicle.state = new EngineVehicleMoving();
    }

    @Override
    public void stopEngine(EngineVehicle vehicle){
        // Do nothing
    }

    @Override
    public void gas(EngineVehicle vehicle, double amount){
        // Do nothing
    }

    @Override
    public void brake(EngineVehicle vehicle, double amount){
        // Do nothing
    }
}
