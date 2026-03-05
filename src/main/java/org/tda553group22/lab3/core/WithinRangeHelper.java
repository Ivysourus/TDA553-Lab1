package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

final class WithinRangeHelper {
    public static boolean withinRange(Vector2 pos, Vector2 otherPos, double range) {
        return pos.distance(otherPos) < range;
    }
}
