package org.tda553group22.lab3.ui.model;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.core.Workshop;
import org.tda553group22.lab3.core.Loadable;
import org.tda553group22.lab3.core.TruckBedFunctions;
import org.tda553group22.lab3.core.TurboFunctions;
import org.tda553group22.lab3.math.Vector2;

public class CarModel {
    private final Vector2 boundsMin;
    private final Vector2 boundsMax;
    private final List<Car> cars = new ArrayList<>();
    private final List<Workshop<? extends Loadable>> workshops = new ArrayList<>();
    private final Map<Integer, MoveObserver> moveObservers = new HashMap<>();
    private final List<UpdateObserver> updateObservers = new ArrayList<>();
    private double elapsedTime;

    public CarModel(Vector2 boundsMin, Vector2 boundsMax) {
        this.boundsMin = boundsMin;
        this.boundsMax = boundsMax;
    }

    public void update(double deltaTime) {
        elapsedTime += deltaTime;
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

            for (Workshop<? extends Loadable> workshop : workshops) {
                if (workshop.canAccept(car) && workshop.withinRange(car.getPos())) {
                    ((Workshop<Loadable>) workshop).load(car);
                }
            }

            moveObservers.get(car.hashCode()).actOnMove(car.getPos(), car.getAngle());
        }

        for (Workshop<? extends Loadable> workshop : workshops) {
            moveObservers.get(workshop.hashCode()).actOnMove(workshop.getPos(), 0);
        }

        for (UpdateObserver observer : updateObservers) {
            observer.actOnUpdate();
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addWorkshop(Workshop<? extends Loadable> workshop) {
        workshops.add(workshop);
    }

    public void addObservedCar(Car car, MoveObserver observer) {
        addCar(car);
        moveObservers.put(car.hashCode(), observer);
    }

    public void addObservedWorkshop(Workshop<? extends Loadable> workshop, MoveObserver observer) {
        addWorkshop(workshop);
        moveObservers.put(workshop.hashCode(), observer);
    }

    public void addUpdateObserver(UpdateObserver observer) {
        updateObservers.add(observer);
    }

    public int getCarCount() {
        return cars.size();
    }

    public Vector2 getBoundsMin() {
        return boundsMin;
    }

    public Vector2 getBoundsMax() {
        return boundsMax;
    }

    public void removeCar(int index) {
        moveObservers.get(cars.get(index).hashCode()).actOnRemove();
        cars.remove(index);
    }

    public void gasAllCars(double amount) {
        for (Car car : cars) {
            car.gas(amount);
        }
    }

    public void brakeAllCars(double amount) {
        for (Car car : cars) {
            car.brake(amount);
        }
    }

    public void startAllEngines() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    public void stopAllEngines() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    public void setTurboOnAllCars() {
        for (Car car : cars) {
            if (car instanceof TurboFunctions turbo) {
                turbo.setTurboOn();
            }
        }
    }

    public void setTurboOffAllCars() {
        for (Car car : cars) {
            if (car instanceof TurboFunctions turbo) {
                turbo.setTurboOff();
            }
        }
    }

    public void raiseBedAllCars() {
        for (Car car : cars) {
            if (car instanceof TruckBedFunctions truckBed) {
                truckBed.raiseBed(Math.PI / 2);
            }
        }
    }

    public void lowerBedAllCars() {
        for (Car car : cars) {
            if (car instanceof TruckBedFunctions truckBed) {
                truckBed.lowerBed(Math.PI / 2);
            }
        }
    }
}
