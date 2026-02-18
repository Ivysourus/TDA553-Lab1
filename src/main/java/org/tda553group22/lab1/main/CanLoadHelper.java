package org.tda553group22.lab1.main;

import java.util.ArrayList;

public abstract class CanLoadHelper<T extends Loadable> {
    protected final ArrayList<T> cargo = new ArrayList<>();
    protected int capacity;

    public void load(T load) {
        assert cargo.size() <= capacity : "Reached max cargo capacity";
        cargo.add(load);
    }
}
