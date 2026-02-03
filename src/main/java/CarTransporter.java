import java.util.Optional;
import java.awt.Color;

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

    @Override
    public void load(PersonCar load) {
        assert rampDown : "Ramp needs to be down to be able to load cars";
        assert this.getCurrentSpeed() == 0 : "You are currently moving";
        assert load.getPos().distance(this.getPos()) > 20 : "The car you are trying to load is too far away from the Transporter";
        assert maxCarry != canLoadHelper.cargo.size() : "The capacity of the truck is at it's maximum";
        load.setPos(this.getPos());
        canLoadHelper.load(load);
    }

    @Override
    public Optional<PersonCar> unload() {
        assert rampDown : "Ramp needs to be down to be able to unload cars";
        assert this.getCurrentSpeed() == 0 : "You are currently moving";
        if (canLoadHelper.unload().isPresent()){
            PersonCar unloadedCar = canLoadHelper.unload().get();
            unloadedCar.setPos(new Vector2(this.getPos().x, this.getPos().y-20));
            return Optional.of(unloadedCar);
        }
        return Optional.empty();
    }

    @Override
    public void move() {
        super.move();
        for (int i = 0; i < canLoadHelper.cargo.size(); i++){
            canLoadHelper.cargo.get(i).pos = this.pos;
        }
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
