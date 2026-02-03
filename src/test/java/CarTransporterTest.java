import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CarTransporterTest {
    private final CarTransporter trans = new CarTransporter();
    private final PersonCar vroom = new Volvo240();

    @Test
    void lowerRampTest() {
        assertThrows(AssertionError.class, trans::lowerRamp);
        trans.raiseRamp();
        trans.gas(1.0);
        assertThrows(AssertionError.class, trans::lowerRamp);
        trans.stopEngine();
    }

    @Test
    void raiseRampTest() {
        trans.raiseRamp();
        assertThrows(AssertionError.class, trans::raiseRamp);
        trans.lowerRamp();
        trans.gas(1.0);
        assertThrows(AssertionError.class, trans::raiseRamp);
        trans.stopEngine();
    }

    @Test
    void loadTest() {
        trans.raiseRamp();
        assertThrows(AssertionError.class, ()->trans.load(vroom));
        trans.lowerRamp();
        trans.gas(1.0);
        assertThrows(AssertionError.class, ()->trans.load(vroom));
        trans.stopEngine();
        vroom.pos = new Vector2(30, 30);
        assertThrows(AssertionError.class, ()->trans.load(vroom));
    }

    @Test
    void unloadTest() {
        trans.load(vroom);
        trans.raiseRamp();
        assertThrows(AssertionError.class, trans::unload);
        trans.lowerRamp();
        trans.gas(1.0);
        assertThrows(AssertionError.class, trans::unload);
        trans.stopEngine();
        trans.unload();
        // One last for if everything works but list is empty or whatever
    }
}
