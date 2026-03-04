package org.tda553group22.lab3.ui.model;

import org.tda553group22.lab3.math.Vector2;

public final class UpdateObserverShort extends MoveObserver {
    private final UpdateAction action;

    public UpdateObserverShort(MoveAction action) {
        this.action = action;
    }

    @Override
    public final void actOnMove(Vector2 pos, double angle) {
        action.actOnMove(pos, angle);
    }
}
