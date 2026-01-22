import java.awt.*;

public abstract class Car implements Movable {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    private double angle; // Angle of the car
    private double xPos; // X coordinate
    private double yPos; // X coordinate

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    private void turn(double angle) {
        this.angle += angle;
    }

    public void move() {
        this.xPos += Math.cos(angle) * currentSpeed;
        this.yPos += Math.sin(angle) * currentSpeed;
    };

    public void turnLeft() {
        turn(Math.PI * 0.5);
    };

    public void turnRight() {
        turn(Math.PI * -0.5);
    };
}
