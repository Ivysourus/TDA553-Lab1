package org.tda553group22.lab3.ui.model;

import java.util.List;
import java.util.ArrayList;

import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.math.Vector2;

public class Model {
    private Vector2 boundsMin;
    private Vector2 boundsMax;
    private List<Car> cars = new ArrayList<>();
    private List<Workshop> workshops = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Model(Vector2 boundsMin, Vector2 boundsMax) {
        this.boundsMin = boundsMin;
        this.boundsMax = boundsMax;
    }

    public Model(Vector2 boundsMin, Vector2 boundsMax, List<Observer> observers) {
        Model(boundsMin, boundsMax);
        this.observers = observers;
    }

    public void addObserver(Car car, Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Car car, Observer observer) {
        observers.remove(observer);
    }

    public void update() {
        for (Observer observer : observers) {
            observer.actOnMove(, angle);
        }
    }
}
