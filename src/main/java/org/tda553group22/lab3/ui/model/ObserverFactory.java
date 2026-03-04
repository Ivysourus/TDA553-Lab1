package org.tda553group22.lab3.ui.model;

import org.tda553group22.lab3.math.Vector2;

public final class ObserverFactory {
    public static MoveObserver makeMoveObserver(MoveAction action) {
        return new MoveObserver() {
            @Override
            public void actOnMove(Vector2 pos, double angle) {
                action.actOnMove(pos, angle);
            }
        };
    }

    public static RemoveObserver makeRemoveObserver(RemoveAction action) {
        return new RemoveObserver() {
            @Override
            public void actOnRemove() {
                action.actOnRemove();
            }
        };
    }

    public static UpdateObserver makeUpdateObserver(UpdateAction action) {
        return new UpdateObserver() {
            @Override
            public void actOnUpdate() {
                action.actOnUpdate();
            }
        };
    }

    public static CompositeObserver makeCompositeObserver(EverythingObserver[] observers) {
        return new CompositeObserver(observers);
    }
}
