package org.tda553group22.lab3.main;

import java.util.Optional;
import java.awt.Color;

public class CarTransporter extends Car implements CanLoadOrdered<PersonCar>  {
    private final CanLoadHelperFirstInLastOut<PersonCar> canLoadHelper;
    private final double maxLoadDistance;
    private boolean rampDown;

    public CarTransporter() {
        nrDoors = 2;
        enginePower = 80;
        color = Color.pink;
        modelName = "Transportmaxxer 5000";
        rampDown = true;
        canLoadHelper = new CanLoadHelperFirstInLastOut<>(3);
        maxLoadDistance = 20.0;
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
        assert rampDown : "Ramp needs to be down to be able to load cars";
        assert getCurrentSpeed() == 0 : "You are currently moving";
        assert load.getPos().distance(pos) < maxLoadDistance : "The car you are trying to load is too far away from the Transporter";
        load.setPos(pos);
        canLoadHelper.load(load);
    }

    @Override
    public Optional<PersonCar> unload() {
        assert rampDown : "Ramp needs to be down to be able to unload cars";
        assert getCurrentSpeed() == 0 : "You are currently moving";
        Optional<PersonCar> unloadedCar = canLoadHelper.unload();
        if (unloadedCar.isEmpty()) {
            return unloadedCar;
        }
        unloadedCar.get().setPos(pos.sub(new Vector2(0, -maxLoadDistance)));
        return unloadedCar;
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
}
