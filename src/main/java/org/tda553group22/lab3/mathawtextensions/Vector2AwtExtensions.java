package org.tda553group22.lab3.mathawtextensions;

import java.awt.Point;

import org.tda553group22.lab3.math.Vector2;

public final class Vector2AwtExtensions {
    public static final Point toPoint(Vector2 vector) {
        return new Point((int) Math.round(vector.x), (int) Math.round(vector.y));
    }
}
