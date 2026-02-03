public abstract class Car extends Vehicle {
    protected int nrDoors;
    protected double enginePower;

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Increases the speed of the car.
     * 
     * @param amount The amount to speed up by in the range [0,1].
     */
    public void gas(double amount) {
        assert amount >= 0.0 && amount <= 1.0 : "Variable `amount` outside the range [0,1]";
        incrementSpeed(amount);
    }

    /**
     * Decreases the speed of the car.
     * 
     * @param amount The amount to slow down by in the range [0,1].
     */
    public void brake(double amount) {
        assert amount >= 0.0 && amount <= 1.0 : "Variable `amount` outside the range [0,1]";
        decrementSpeed(amount);
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    abstract protected double speedFactor();
}
