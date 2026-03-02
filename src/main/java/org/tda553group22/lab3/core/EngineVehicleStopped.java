package org.tda553group22.lab3.core;

public class EngineVehicleStopped implements EngineVehicleState {
    public void startEngine(EngineVehicle vehicle){
        vehicle.currentSpeed = 0.1;
        vehicle.state = new EngineVehicleMoving();
    }

    public void stopEngine(EngineVehicle vehicle){
        // Do nothing
    }

    public void gas(EngineVehicle vehicle, double amount){
        // Do nothing
    }

    public void brake(EngineVehicle vehicle, double amount){
        // Do nothing
    }
}
