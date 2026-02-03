import java.awt.Color;

public abstract class Vehicle implements Movable {
    protected double currentSpeed;
    protected String modelName;
    protected Color color;

    private double xPos;
    private double yPos;
    private double angle;

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public double getAngle() {
        return angle;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    public void move() {
        this.xPos += Math.cos(angle) * currentSpeed;
        this.yPos += Math.sin(angle) * currentSpeed;
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
