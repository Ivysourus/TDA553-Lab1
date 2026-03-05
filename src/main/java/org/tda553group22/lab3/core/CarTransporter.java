package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

import java.util.Optional;
import java.awt.Color;

public class CarTransporter extends Car implements CanLoadOrdered<PersonCar>  {
    private final CanLoadHelperFirstInLastOut<PersonCar> canLoadHelper;
    private final double maxLoadDistance;
    private boolean rampDown;

    public CarTransporter(Vector2 pos) {
        nrDoors = 2;
        enginePower = 80;
        color = Color.pink;
        modelName = "Transportmaxxer 5000";
        rampDown = true;
        canLoadHelper = new CanLoadHelperFirstInLastOut<>(3, PersonCar.class);
        maxLoadDistance = 20.0;
        this.pos = pos;
    }

    public void lowerRamp() {
        assert !rampDown : "Ramp is already down";
        assert getCurrentSpeed() == 0 : "You are currently moving";
        rampDown = true;
    }

    public void raiseRamp() {
        assert rampDown : "Ramp is already up";
        assert getCurrentSpeed() == 0 : "You are currently moving";
        rampDown = false;
    }

    @Override
    public void load(PersonCar load) {
        loadedAction(load);
        canLoadHelper.load(load);
    }

    @Override
    public Optional<PersonCar> unload() {
        if (!loadingReady()) {
            return Optional.empty();
        }

        Optional<PersonCar> unloadedCar = canLoadHelper.unload();
        if (unloadedCar.isEmpty()) {
            return unloadedCar;
        }

        unloadedCar.get().setPos(pos.sub(new Vector2(0, -maxLoadDistance)));
        return unloadedCar;
    }

    @Override
    public boolean tryLoad(Loadable load) {
        if (!canAccept(load)) {
            return false;
        }

        boolean success = canLoadHelper.tryLoad(load);

        if (!success) {
            return false;
        }

        loadedAction((PersonCar) load);

        return true;
    }

    @Override
    public boolean canAccept(Loadable load) {
        return canLoadHelper.canAccept(load) &&
                WorkshopWithinRangeHelper.withinRange(pos, load.getPos(), maxLoadDistance) &&
                loadingReady();
    }

    @Override
    public void move() {
        super.move();
        for (var car : canLoadHelper.cargo){
            car.pos = pos;
        }
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    private void loadedAction(PersonCar load) {
        load.stopEngine();
        load.setPos(pos);
        load.setEngineVehicleState(new EngineVehicleLocked(load));
    }

    private boolean loadingReady() {
        return rampDown && getCurrentSpeed() == 0;
    }
}
