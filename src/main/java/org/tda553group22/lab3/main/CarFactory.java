package org.tda553group22.lab3.main;

import org.tda553group22.lab3.math.Vector2;

public final class CarFactory {
    public static Car createVolvo240(Vector2 pos) {
        Volvo240 volvo = new Volvo240();
        volvo.setPos(pos);
        return volvo;

    }

    public static Car createSaab95(Vector2 pos) {
        Saab95 saab = new Saab95();
        saab.setPos(pos);
        return saab;
    }

    public static Car createScania(Vector2 pos) {
        Scania scania = new Scania();
        scania.setPos(pos);
        return scania;
    }
}
