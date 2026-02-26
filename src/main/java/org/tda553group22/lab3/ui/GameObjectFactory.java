package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.core.CanLoadUnordered;
import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.core.CarFactory;
import org.tda553group22.lab3.core.CanLoadUnorderedFactory;

public class GameObjectFactory {
    public GameObject<CanLoadUnordered<? extends Car>> createVolvoWorkshop(int capacity, Vector2 pos) {
        return new GameObjectWrapWithInnerSpriteAndPosition<CanLoadUnordered<? extends Car>>(CanLoadUnorderedFactory.createVolvoWorkshop(capacity, pos), ResourcesHandler.volvoWorkshopImage, pos);
    }

    public GameObject<? extends Car> createVolvo240(Vector2 pos) {
        return new GameObjectWrapWithInnerAndSprite<Car>(CarFactory.createVolvo240(pos), ResourcesHandler.volvoImage);
    }

    public GameObject<? extends Car> createSaab95(Vector2 pos) {
        return new GameObjectWrapWithInnerAndSprite<Car>(CarFactory.createSaab95(pos), ResourcesHandler.saabImage);
    }

    public GameObject<? extends Car> createScania(Vector2 pos) {
        return new GameObjectWrapWithInnerAndSprite<Car>(CarFactory.createScania(pos), ResourcesHandler.scaniaImage);
    }
}
