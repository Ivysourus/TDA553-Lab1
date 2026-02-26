package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

class CarWorkshop<T extends Car> implements Workshop<T> {
    private Vector2 pos;
    private final CanLoadHelperUnordered<T> canLoadHelper;
    private final Class<T> supportedType;
    private static double range = 30;

    public CarWorkshop(Vector2 pos, int capacity, Class<T> supportedType) {
        this.pos = pos;
        canLoadHelper = new CanLoadHelperUnordered<>(capacity);
        this.supportedType = supportedType;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public boolean isWithinRange(Vector2 pos) {
        return WorkshopWithinRangeHelper.isWithinRange(this.pos, pos, range);
    }

    @Override
    public boolean canAccept(Loadable load) {
        return supportedType.isInstance(load);
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
