package org.tda553group22.lab3.core;

import java.util.Optional;

public interface CanLoadOrdered<T extends Loadable> extends CanLoadBase<T> {
    Optional<T> unload();
}
