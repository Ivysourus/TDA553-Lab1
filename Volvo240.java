import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    private double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
