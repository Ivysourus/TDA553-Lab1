package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.main.CanLoadUnordered;
import org.tda553group22.lab3.main.Car;
import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.main.CarFactory;
import org.tda553group22.lab3.main.CanLoadUnorderedFactory;
import org.tda553group22.lab3.main.PositionFunctions;

public class GameObjectFactory {

    public GameObject<CanLoadUnordered<? extends Car>> createVolvoWorkshop(int capacity, Vector2 pos) {
        new GameObjectWrapWithSprite<CanLoadUnordered<? extends Car> & PositionFunctions>(CanLoadUnorderedFactory.createVolvoWorkshop(capacity, pos), ResourcesHandler.volvoWorkshopImage);
        return
    }

    public Gameobject<? extends Car> createVolvo240(Vector2 pos) {
        return CarFactory.createVolvo240(pos);
    }

    public GameObject<? extends Car> createSaab95(Vector2 pos) {
        return CarFactory.createSaab95(pos);
    }

    public GameObject<? extends Car> createScania(Vector2 pos) {
        return CarFactory.createScania(pos);
    }
}
