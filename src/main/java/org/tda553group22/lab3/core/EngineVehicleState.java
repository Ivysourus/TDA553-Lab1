package org.tda553group22.lab3.core;

interface EngineVehicleState {
    void startEngine();

    void stopEngine();

    void gas(double amount);

    void brake(double amount);

    void move();

    int getEngineVehicleHashCode();
}
