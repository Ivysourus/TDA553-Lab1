package org.tda553group22.lab3.main;

import java.util.Optional;

interface CanLoadOrdered<T extends Loadable> {
    void load(T load);

    Optional<T> unload();
}
