package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.mathawtextensions.Vector2AwtExtensions;
import org.tda553group22.lab3.ui.model.Model;

class Main {
    public static void main(String[] args) {
        Vector2 boundsMin = new Vector2(0, 0);
        Vector2 boundsExtents = new Vector2(1000, 800);
        Vector2 boundsMax = boundsMin.add(new Vector2(boundsExtents.x - 110, boundsExtents.y)); // -110 for the size of images.

        Model model = new Model(boundsMin, boundsMax);
        CarController carController = new CarController("CarSim 1.0", Vector2AwtExtensions.toDimension(boundsExtents), model);

        carController.addVolvo240(new Vector2(0, 0));
        carController.addSaab95(new Vector2(0, 100));
        carController.addScania(new Vector2(0, 200));
        carController.addVolvoWorkshop(new Vector2(500, 0), 1);
    }
}
