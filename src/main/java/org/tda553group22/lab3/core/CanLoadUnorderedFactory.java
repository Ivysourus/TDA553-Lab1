package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

public final class CanLoadUnorderedFactory {
    public static CanLoadUnordered<Volvo240> createVolvoWorkshop(Vector2 pos, int capacity) {
        return new Workshop<>(pos, capacity);
    }
}
