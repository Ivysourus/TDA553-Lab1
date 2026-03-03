package org.tda553group22.lab3.core;

interface TruckBedState extends TruckBedFunctions {
    void raiseBed(double angle);

    void lowerBed(double angle);

    int getTruckHashCode();
}
