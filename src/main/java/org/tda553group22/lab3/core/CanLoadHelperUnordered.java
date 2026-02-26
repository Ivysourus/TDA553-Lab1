package org.tda553group22.lab3.core;

class CanLoadHelperUnordered<T extends Loadable> extends CanLoadHelper<T> implements CanLoadUnordered<T> {
    public CanLoadHelperUnordered(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void unload(T load) {
        assert cargo.contains(load) : "Cargo does not contain load";
        cargo.remove(load);
    }
}
