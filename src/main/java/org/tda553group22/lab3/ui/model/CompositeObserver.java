package org.tda553group22.lab3.ui.model;

import org.tda553group22.lab3.math.Vector2;

final class CompositeObserver implements EverythingObserver {
    private final EverythingObserver[] observers;

    public CompositeObserver(EverythingObserver[] observers) {
        this.observers = observers;
    }

    @Override
    public void actOnMove(Vector2 pos, double angle) {
        for (EverythingObserver o : observers) {
            o.actOnMove(pos, angle);
        }
    }

    @Override
    public void actOnRemove() {
        for (EverythingObserver o : observers) {
            o.actOnRemove();
        }
    }

    @Override
    public void actOnUpdate() {
        for (EverythingObserver o : observers) {
            o.actOnUpdate();
        }
    }
}
