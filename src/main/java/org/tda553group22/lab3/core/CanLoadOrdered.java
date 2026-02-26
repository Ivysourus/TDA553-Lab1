package org.tda553group22.lab3.core;

import java.util.Optional;

interface CanLoadOrdered<T extends Loadable> {
    void load(T load);

    Optional<T> unload();
}
