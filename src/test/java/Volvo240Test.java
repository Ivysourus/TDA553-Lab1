import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

class Volvo240Test {
    private final Volvo240 volvo240 = new Volvo240();

    @Test
    void getNrDoors() {
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(100.0, volvo240.getEnginePower());
    }

    @Test
    void initialSpeedZero() {
        assertEquals(0.0, volvo240.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.black, volvo240.getColor());
    }

    @Test
    void setColor() {
        Color color = Color.red;
        volvo240.setColor(color);
        assertEquals(color, volvo240.getColor());
    }

    @Test
    void startEngine() {
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        volvo240.stopEngine();
        assertEquals(0.0, volvo240.getCurrentSpeed());
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
    void gasWithAmountOutsideRange() {
        assertThrows(AssertionError.class, () -> volvo240.gas(2.0));
        assertThrows(AssertionError.class, () -> volvo240.gas(-1.0));
    }

    @Test
    void brakeWithAmountOutsideRange() {
        assertThrows(AssertionError.class, () -> volvo240.brake(2.0));
        assertThrows(AssertionError.class, () -> volvo240.brake(-1.0));
    }

    @Test
    void enginePowerIsMaxSpeed() {
        for (int i = 0; i < 100; i++) {
            volvo240.gas(1);
        }
        assertEquals(volvo240.enginePower, volvo240.getCurrentSpeed());
    }

    @Test
    void zeroIsMinSpeed() {
        volvo240.brake(1);
        assertEquals(0.0, volvo240.getCurrentSpeed());
    }

    @Test
    void move() {
        volvo240.startEngine();
        volvo240.gas(1.0);
        volvo240.turnLeft();
        Vector2 initial = volvo240.getPos();
        volvo240.move();
        Vector2 after = volvo240.getPos();
        assertNotEquals(initial.x, after.x);
        assertNotEquals(initial.y, after.y);
    }

    @Test
    void moveWithZeroSpeed() {
        Vector2 initial = volvo240.getPos();
        volvo240.move();
        Vector2 after = volvo240.getPos();
        assertEquals(initial.x, after.x);
        assertEquals(initial.y, after.y);
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
}
