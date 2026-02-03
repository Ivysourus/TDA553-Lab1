import java.awt.Color;
import java.util.ArrayList;
import java.util.Optional;

public class CarFerry extends EngineVehicle {
    private int carLanes;
    private ArrayList<CanLoadHelperFirstInFirstOut<Car>> laneCanLoadHelpers;

    public CarFerry(int carLanes) {
        color = Color.black;
        enginePower = 100;
        modelName = "Mecklenburg – Vorpommern";
        laneCanLoadHelpers = new ArrayList<CanLoadHelperFirstInFirstOut<PersonCar>>(carLanes);
        this.carLanes = carLanes;
    }

    public void Load(PersonCar car, int lane) {
        assert lane <= carLanes : "Parameter `lane` cannot be larger than the amount of lanes on the ferry";
        assert lane <= carLanes : "Parameter `lane` cannot be smaller than zero";
        laneCanLoadHelpers.get(lane).Load(car);
    }

    public Optional<PersonCar> Unload(int lane) {
        assert lane <= carLanes : "Parameter `lane` cannot be larger than the amount of lanes on the ferry";
        assert lane <= carLanes : "Parameter `lane` cannot be smaller than zero";
        return laneCanLoadHelpers.get(lane).Unload();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
