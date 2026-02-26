package org.tda553group22.lab3.core;

import java.util.Optional;

class CanLoadHelperFirstInLastOut<T extends Loadable> extends CanLoadHelper<T> implements CanLoadOrdered<T> {
    public CanLoadHelperFirstInLastOut(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Optional<T> unload() {
        if (cargo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cargo.remove(-1));
    }
}
