package org.tda553group22.lab1.main;

public interface CanLoadUnordered<T extends Loadable> {
    void load(T load);

    void unload(T load);
}
