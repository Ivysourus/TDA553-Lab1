package org.tda553group22.lab3.math;

import java.awt.Point;

public final class Vector2 {
    public final double x;
    public final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 another) {
        this(another.x, another.y);
    }

    public static Vector2 zero() {
        return new Vector2(0.0, 0.0);
    }

    public double magnitudeSquared() {
        return x * x + y * y;
    }

    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    public double distance(Vector2 other) {
        return other.sub(this).magnitude();
    }

    public Vector2 normalized() {
        return div(magnitude());
    }

    public Vector2 clamp(Vector2 min, Vector2 max) {
        return new Vector2(Math.clamp(x, min.x, max.x), Math.clamp(y, min.y, max.y));
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 sub(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 mul(Vector2 other) {
        return new Vector2(x * other.x, y * other.y);
    }

    public Vector2 mul(double scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    public Vector2 div(Vector2 other) {
        return new Vector2(x / other.x, y / other.y);
    }

    public Vector2 div(double scalar) {
        return new Vector2(x / scalar, y / scalar);
    }

    public Vector2 inv() {
        return new Vector2(-x, -y);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Vector2 other) &&
                x == other.x &&
                y == other.y;
    }

    @Override
    public String toString() {
        return String.format("Vector2 : (%(,.2f, %(,.2f)", x, y);
    }
}
