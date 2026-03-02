package org.tda553group22.lab3.core;

public interface EngineVehicleState {
    void startEngine(EngineVehicle vehicle);

    void stopEngine(EngineVehicle vehicle);

    void gas(EngineVehicle vehicle, double amount);

    void brake(EngineVehicle vehicle, double amount);
}
