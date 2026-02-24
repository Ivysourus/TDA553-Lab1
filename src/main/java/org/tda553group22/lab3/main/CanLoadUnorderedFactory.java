package org.tda553group22.lab3.main;

import org.tda553group22.lab3.math.Vector2;

public final class CanLoadUnorderedFactory {

    public static CanLoadUnordered<Volvo240> createVolvoWorkshop(int capacity, Vector2 pos) {
        return new WorkshopWithPosition<>(capacity, pos);
    }
}
