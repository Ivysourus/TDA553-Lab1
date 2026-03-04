package org.tda553group22.lab3.core;

public interface CanLoadUnordered<T extends Loadable> extends CanLoadBase<T> {
    void unload(T load);
}
