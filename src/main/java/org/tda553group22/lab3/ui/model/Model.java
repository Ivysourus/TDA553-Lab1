package org.tda553group22.lab3.ui.model;

import java.util.List;
import java.util.ArrayList;

import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.math.Vector2;

public class Model {
    private Vector2 boundsMin;
    private Vector2 boundsMax;
    private List<Car> cars = new ArrayList<>();

    public Model(Vector2 boundsMin, Vector2 boundsMax) {
        this.boundsMin = boundsMin;
        this.boundsMax = boundsMax;
    }

    public void update() {

    }
}
