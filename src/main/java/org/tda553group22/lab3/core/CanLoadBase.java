package org.tda553group22.lab3.core;

abstract interface CanLoadBase<T extends Loadable> {
    void load(T load);

    boolean tryLoad(Loadable load);

    boolean canAccept(Loadable load);
}

