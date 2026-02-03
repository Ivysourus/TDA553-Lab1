public class Vector2 {
    public double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 another) {
        this.x = another.x;
        this.y = another.y;
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector2 normalized() {
        return this.div(this.magnitude());
    }

    public double distance(Vector2 other) {
        return other.sub(this).magnitude();
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 sub(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 mul(Vector2 other) {
        return new Vector2(this.x * other.x, this.y * other.y);
    }

    public Vector2 mul(double scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }

    public Vector2 div(Vector2 other) {
        return new Vector2(this.x / other.x, this.y / other.y);
    }

    public Vector2 div(double scalar) {
        return new Vector2(this.x / scalar, this.y / scalar);
    }

    public Vector2 inv() {
        return new Vector2(-this.x, -this.y);
    }
}
