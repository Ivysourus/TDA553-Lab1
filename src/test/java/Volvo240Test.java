import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Volvo240Test {
    private final Volvo240 volvo240 = new Volvo240();

    @Test
    void getNrDoors() {
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void gas() {
        double amount = 1.0;
        volvo240.startEngine();
        double initialSpeed = volvo240.getCurrentSpeed();
        volvo240.gas(amount);
        assertTrue(initialSpeed < volvo240.getCurrentSpeed());
    }

    @Test
    void brake() {
        double amount = 1.0;
        volvo240.startEngine();
        double initialSpeed = volvo240.getCurrentSpeed();
        volvo240.brake(amount);
        assertTrue(initialSpeed > volvo240.getCurrentSpeed());
    }

    @Test
    void move() {
        volvo240.startEngine();
        volvo240.gas(1.0);
        volvo240.turnLeft();
        System.out.println(volvo240.getCurrentSpeed());
        double initialX = volvo240.getXPos();
        double initialY = volvo240.getYPos();
        volvo240.move();
        assertNotEquals(initialX, volvo240.getXPos());
        assertNotEquals(initialY, volvo240.getYPos());
    }

    @Test
    void moveWithZeroSpeed() {
        double initialX = volvo240.getXPos();
        double initialY = volvo240.getYPos();
        volvo240.move();
        assertEquals(initialX, volvo240.getXPos());
        assertEquals(initialY, volvo240.getYPos());
    }

    @Test
    void turnLeft() {
        double initialAngle = volvo240.getAngle();
        volvo240.turnLeft();
        assertTrue(initialAngle < volvo240.getAngle());
    }

    @Test
    void turnRight() {
        double initialAngle = volvo240.getAngle();
        volvo240.turnRight();
        assertTrue(initialAngle > volvo240.getAngle());
    }

    @Test
    void speedFactor() {
    }
}
