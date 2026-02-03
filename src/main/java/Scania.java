public class Scania extends Truck {
    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}
