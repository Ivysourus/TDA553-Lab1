package org.tda553group22.lab3.core;

import java.util.Optional;

class CanLoadHelperFirstInFirstOut<T extends Loadable> extends CanLoadHelper<T> implements CanLoadOrdered<T> {
    public CanLoadHelperFirstInFirstOut(int capacity, Class<T> supportedType) {
        this.capacity = capacity;
        this.supportedType = supportedType;
    }

    @Override
    public Optional<T> unload() {
        if (cargo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cargo.removeFirst());
    }
}
