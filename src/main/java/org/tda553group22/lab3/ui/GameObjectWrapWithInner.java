package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.core.PositionFunctions;
import org.tda553group22.lab3.math.Vector2;

import java.awt.image.BufferedImage;

class GameObjectWrapWithInner<T extends HasSprite & PositionFunctions> implements GameObject<T> {
    private final T inner;

    public GameObjectWrapWithInner(T inner) {
        this.inner = inner;
    }

    public T getInner() {
        return inner;
    }

    public BufferedImage getSprite() {
        return inner.getSprite();
    }

    public Vector2 getPos() {
        return inner.getPos();
    }

    public void setPos(Vector2 pos) {
        inner.setPos(pos);
    }
}
