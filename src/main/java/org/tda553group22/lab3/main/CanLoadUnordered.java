package org.tda553group22.lab3.main;

interface CanLoadUnordered<T extends Loadable> {
    void load(T load);

    void unload(T load);
}
