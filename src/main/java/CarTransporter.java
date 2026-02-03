import java.util.Optional;
import java.awt.*;

public class CarTransporter extends Car implements CanLoadOrdered<PersonCar>  {
    private CanLoadHelperFirstInLastOut<PersonCar> canLoadHelper;
    private boolean rampDown;
    private final int maxCarry;

    public CarTransporter(){
        rampDown = true;
        maxCarry = 3;
        nrDoors = 2;
        enginePower = 80;
        color = Color.pink;
        modelName = "Transporter 200";
        stopEngine();
    }

    public void lowerRamp(){
        assert !rampDown : "Ramp is already down";
        assert this.getCurrentSpeed() == 0 : "You are currently moving";
        rampDown = true;
    }

    public void raiseRamp(){
        assert rampDown : "Ramp is already up";
        assert this.getCurrentSpeed() == 0 : "You are currently moving";
        rampDown = false;
    }

    public void Load(Loadable<PersonCar> load) {
        assert rampDown : "Ramp needs to be down to be able to load cars";
        assert this.getCurrentSpeed() == 0 : "You are currently moving";
        assert load.getPos().distance(this.getPos()) > 20 : "The car you are trying to load is too far away from the Transporter";
        assert maxCarry != canLoadHelper.cargo.size() : "The capacity of the truck is at it's maximum";
        load.setPosition(this.getPos());
        canLoadHelper.Load(load);
    }

    public Optional<Loadable<PersonCar>> Unload() {
        assert rampDown : "Ramp needs to be down to be able to unload cars";
        assert this.getCurrentSpeed() == 0 : "You are currently moving";
        Optional<Loadable<PersonCar>> UnloadingCar = canLoadHelper.Unload();
        // TODO this needs to put down the car -20 on Y axis



        return UnloadingCar;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
