package org.tda553group22.lab3.core;

public interface CanLoadUnordered<T extends Loadable> {
    void load(T load);

    void unload(T load);
}
