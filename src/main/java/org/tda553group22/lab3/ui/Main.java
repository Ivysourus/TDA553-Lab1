package org.tda553group22.lab3.ui;

import java.util.ArrayList;

import org.tda553group22.lab3.main.Car;
import org.tda553group22.lab3.main.Saab95;
import org.tda553group22.lab3.main.Scania;
import org.tda553group22.lab3.main.Volvo240;
import org.tda553group22.lab3.main.WorkshopWithPosition;
import org.tda553group22.lab3.math.Vector2;

class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Volvo240(new Vector2(0, 0)));
        cars.add(new Scania(new Vector2(0, 100)));
        cars.add(new Saab95(new Vector2(0, 200)));

        WorkshopWithPosition<Volvo240> workshop = new WorkshopWithPosition<>(1, new Vector2(300, 0));

        // Init singleton
        new CarController(cars, workshop);
    }
}
