package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.mathawtextensions.Vector2AwtExtensions;
import org.tda553group22.lab3.ui.model.Model;

class Main {
    public static void main(String[] args) {
        Vector2 boundsMin = new Vector2(0, 0);
        Vector2 boundsExtents = new Vector2(1000, 800);
        Vector2 boundsMax = boundsMin.add(boundsExtents);

        Model model = new Model(boundsMin, boundsMax);
        CarView view = new CarView("CarSim", Vector2AwtExtensions.toDimension(boundsExtents));
        CarController carController = new CarController(model, view);

        carController.addVolvo240(new Vector2(0, 0));
        carController.addSaab95(new Vector2(0, 100));
        carController.addScania(new Vector2(0, 200));
        carController.addVolvoWorkshop(new Vector2(500, 0), 1);
    }
}
