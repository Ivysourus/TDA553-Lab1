package org.tda553group22.lab3.ui;

import java.util.ArrayList;

import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.core.CarFactory;
import org.tda553group22.lab3.core.Volvo240;
import org.tda553group22.lab3.core.Workshop;
import org.tda553group22.lab3.math.Vector2;

class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(CarFactory.createVolvo240(new Vector2(0, 0)));
        cars.add(CarFactory.createSaab95(new Vector2(0, 100)));
        cars.add(CarFactory.createScania(new Vector2(0, 200)));

        Workshop<Volvo240> workshop = new Workshop<>(new Vector2(300, 0),1);

        // Init singleton
        new CarController(cars, workshop);
    }
}
