package org.tda553group22.lab3.main;

import org.tda553group22.lab3.math.Vector2;

public final class CarFactory {
    public static Car createVolvo240(Vector2 pos) {
        return new Volvo240(pos);
    }

    public static Car createSaab95(Vector2 pos) {
        return new Saab95(pos);
    }

    public static Car createScania(Vector2 pos) {
        return new Scania(pos);
    }
}
