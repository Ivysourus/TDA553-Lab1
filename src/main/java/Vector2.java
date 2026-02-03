public class Vector2 {
    public final double x;
    public final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 another) {
        x = another.x;
        y = another.y;
    }

    public static Vector2 zero() {
        return new Vector2(0.0, 0.0);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector2 normalized() {
        return div(magnitude());
    }

    public double distance(Vector2 other) {
        return other.sub(this).magnitude();
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
}
