package org.tda553group22.lab3.main;

import java.util.ArrayList;
import java.util.List;

abstract class CanLoadHelper<T extends Loadable> {
    protected final List<T> cargo = new ArrayList<>();
    protected int capacity;

    public void load(T load) {
        assert cargo.size() <= capacity : "Reached max cargo capacity";
        cargo.add(load);
    }
}
