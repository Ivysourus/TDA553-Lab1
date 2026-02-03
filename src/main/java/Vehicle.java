import java.awt.Color;

public abstract class Vehicle implements Movable {
    protected double currentSpeed;
    protected String modelName;
    protected Color color;

    private Vector2 pos;
    private double angle;

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public Vector2 getPos() {
        return new Vector2(pos);
    }

    public double getAngle() {
        return angle;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    public void move() {
        this.pos = pos.add(new Vector2(
            Math.cos(angle) * currentSpeed,
            Math.sin(angle) * currentSpeed));
    };

    private void turn(double angle) {
        this.angle += angle;
    }

    public void turnLeft() {
        turn(Math.PI * 0.5);
    };

    public void turnRight() {
        turn(Math.PI * -0.5);
    };
}
