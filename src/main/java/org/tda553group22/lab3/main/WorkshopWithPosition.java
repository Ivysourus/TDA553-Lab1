package org.tda553group22.lab3.main;

public class WorkshopWithPosition<T extends Car> extends Workshop<T> implements HasPosition {
    private final Vector2 pos;

    public WorkshopWithPosition(int capacity, Vector2 pos) {
        super(capacity);
        this.pos = pos;
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }
}
