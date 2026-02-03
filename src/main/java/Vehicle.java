import java.awt.Color;

public abstract class Vehicle implements Movable, Loadable {
    protected double currentSpeed;
    protected String modelName;
    protected Color color;
    protected Vector2 pos = Vector2.zero();

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

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void move() {
        this.pos = pos.add(new Vector2(
            Math.cos(angle) * currentSpeed,
            Math.sin(angle) * currentSpeed));
    }

    private void turn(double angle) {
        this.angle += angle;
    }

    public void turnLeft() {
        turn(Math.PI * 0.5);
    }

    public void turnRight() {
        turn(Math.PI * -0.5);
    }
}
