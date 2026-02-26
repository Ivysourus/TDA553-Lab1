package org.tda553group22.lab3.ui.model;

import java.util.List;
import java.util.ArrayList;

import org.tda553group22.lab3.core.CanLoadUnordered;
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
        this(boundsMin, boundsMax);
        this.observers = observers;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void update() {
        for (Car car : cars) {
            car.move();

            Vector2 pos = car.getPos();
            Vector2 clampedPos = pos.clamp(boundsMin, boundsMax);
            if (!clampedPos.equals(pos)) {
                car.setPos(clampedPos);
                car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                car.startEngine();
            }

            for (CanLoadUnordered workshop)
            if (car.getPos().distance()
                    car.getPos().distance(volvoWorkshop.getPos()) < 30) {
                volvoWorkshop.load(volvo);
            }

            frame.moveById(car.hashCode(), Vector2AwtExtensions.toPoint(car.getPos()));
        }

        for (Observer observer : observers) {
            observer.actOnMove(, angle);
        }
    }
}
