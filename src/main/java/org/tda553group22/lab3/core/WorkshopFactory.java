package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

public final class WorkshopFactory {
    public static Workshop<Volvo240> createVolvoWorkshop(Vector2 pos, int capacity) {
        return new CarWorkshop<Volvo240>(pos, capacity, Volvo240.class);
    }
}
