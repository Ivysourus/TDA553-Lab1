package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

public class Workshop<T extends Car> implements CanLoadUnordered<T>, PositionFunctions {
    private Vector2 pos;
    private final CanLoadHelperUnordered<T> canLoadHelper;

    public Workshop(Vector2 pos, int capacity) {
        this.pos = pos;
        canLoadHelper = new CanLoadHelperUnordered<>(capacity);
    }

    @Override
    public void load(T load) {
        load.stopEngine();
        canLoadHelper.load(load);
    }

    @Override
    public void unload(T load) {
        canLoadHelper.unload(load);
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }

    @Override
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
}
