import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

class ScaniaTest {
    private final Scania scania = new Scania();

    @Test
    void raiseBedAtZero() {
        double initial = scania.getBedAngle();
        double angle = 0.1*Math.PI;
        scania.raiseBed(angle);
        assertEquals(scania.getBedAngle(), initial+angle);
    }

    void lowerBedAtZero() {
        double initial = scania.getBedAngle();
        double angle = 0.1*Math.PI;
        scania.lowerBed(angle);
        assertEquals(scania.getBedAngle(), 0);
    }

    void raiseBedMaxLimit() {
        double angle = 2.0*Math.PI;
        scania.raiseBed(angle);
        assertEquals(scania.getBedAngle(), (7.0/18.0)*Math.PI);
    }
}
