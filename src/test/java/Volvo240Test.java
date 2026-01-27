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
    }

    @Test
    void brake() {
    }

    @Test
    void move() {
    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }

    @Test
    void speedFactor() {
    }
}