package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.math.Vector2;

import java.awt.image.BufferedImage;

class GameObjectWrapWithInnerSpriteAndPosition<T> implements GameObject<T> {
    private final T inner;
    private final BufferedImage sprite;
    private Vector2 pos;

    public GameObjectWrapWithInnerSpriteAndPosition(T inner, BufferedImage sprite, Vector2 pos) {
        this.inner = inner;
        this.sprite = sprite;
        this.pos = pos;
    }

    public T getInner() {
        return inner;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
}
