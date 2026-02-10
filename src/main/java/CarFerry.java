import java.awt.Color;
import java.util.ArrayList;
import java.util.Optional;

public class CarFerry extends EngineVehicle {
    private final int carLanes;
    private final ArrayList<CanLoadHelperFirstInFirstOut<Car>> laneCanLoadHelpers;

    public CarFerry() {
        color = Color.black;
        enginePower = 100;
        modelName = "Mecklenburg – Vorpommern";
        carLanes = 12;
        laneCanLoadHelpers = new ArrayList<>(carLanes);
        for (int i = 0; i < carLanes; i++) {
            laneCanLoadHelpers.add(new CanLoadHelperFirstInFirstOut<>(15));
        }
    }

    public void load(Car car, int lane) {
        assert lane < carLanes : "Parameter `lane` cannot be greater or equal to the amount of lanes on the ferry";
        assert lane >= 0 : "Parameter `lane` cannot be negative";
        laneCanLoadHelpers.get(lane).load(car);
    }

    public Optional<Car> unload(int lane) {
        assert lane < carLanes : "Parameter `lane` cannot be greater or equal to the amount of lanes on the ferry";
        assert lane >= 0 : "Parameter `lane` cannot be negative";
        return laneCanLoadHelpers.get(lane).unload();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
