import java.awt.Color;
import java.util.ArrayList;
import java.util.Optional;

public class CarFerry extends EngineVehicle {
    private final int carLanes;
    private final ArrayList<CanLoadHelperFirstInFirstOut<Car>> laneCanLoadHelpers;

    public CarFerry(int carLanes) {
        color = Color.black;
        enginePower = 100;
        modelName = "Mecklenburg – Vorpommern";
        laneCanLoadHelpers = new ArrayList<>(carLanes);
        this.carLanes = carLanes;
    }

    public void Load(Car car, int lane) {
        assert lane <= carLanes : "Parameter `lane` cannot be larger than the amount of lanes on the ferry";
        assert lane <= carLanes : "Parameter `lane` cannot be smaller than zero";
        laneCanLoadHelpers.get(lane).Load(car);
    }

    public Optional<Car> Unload(int lane) {
        assert lane <= carLanes : "Parameter `lane` cannot be larger than the amount of lanes on the ferry";
        assert lane <= carLanes : "Parameter `lane` cannot be smaller than zero";
        return laneCanLoadHelpers.get(lane).Unload();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
