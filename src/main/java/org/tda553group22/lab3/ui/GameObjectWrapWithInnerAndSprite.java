package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.main.PositionFunctions;
import org.tda553group22.lab3.math.Vector2;

import java.awt.image.BufferedImage;

class GameObjectWrapWithInnerAndSprite<T extends PositionFunctions> implements GameObject<T> {
    private final T inner;
    private final BufferedImage sprite;

    public GameObjectWrapWithInnerAndSprite(T inner, BufferedImage sprite) {
        this.inner = inner;
        this.sprite = sprite;
    }

    public T getInner() {
        return inner;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public Vector2 getPos() {
        return inner.getPos();
    }

    public void setPos(Vector2 pos) {
        inner.setPos(pos);
    }
}
