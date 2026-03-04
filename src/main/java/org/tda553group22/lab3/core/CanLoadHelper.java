package org.tda553group22.lab3.core;

import java.util.ArrayList;
import java.util.List;

abstract class CanLoadHelper<T extends Loadable> implements CanLoadBase<T> {
    protected int capacity;
    protected Class<T> supportedType;

    protected final List<T> cargo = new ArrayList<>();

    @Override
    public void load(T load) {
        if (!belowCapacity()) {
            return;
        }
        cargo.add(load);
    }

    /**
     * Loads an object dynamically by checking if its type matches supportedType.
     *
     * @param load The object to load
     * @return The success of the operation
     */
    @Override
    public boolean tryLoad(Loadable load) {
        if (!canAccept(load)) {
            return false;
        }
        cargo.add((T) load);
        return true;
    }

    @Override
    public boolean canAccept(Loadable load) {
        return belowCapacity() && supportedType.isInstance(load);
    }

    private boolean belowCapacity() {
        return cargo.size() < capacity;
    }
}
