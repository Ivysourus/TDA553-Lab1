package org.tda553group22.lab3.ui.model;

import org.tda553group22.lab3.math.Vector2;

abstract class UpdateObserver implements EverythingObserver {
    @Override
    public final void actOnMove(Vector2 pos, double angle) {
    }

    @Override
    public final void actOnRemove() {
    }

    @Override
    public abstract void actOnUpdate();
}
