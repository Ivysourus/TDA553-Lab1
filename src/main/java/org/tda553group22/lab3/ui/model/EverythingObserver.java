package org.tda553group22.lab3.ui.model;

import org.tda553group22.lab3.math.Vector2;

public interface EverythingObserver extends MoveAction, RemoveAction, UpdateAction {
    void actOnMove(Vector2 pos, double angle);

    void actOnRemove();

    void actOnUpdate();
}
