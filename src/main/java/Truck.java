public abstract class Truck extends Car {
    /**
     * The angle of the truck bed, from 0-`maxBedAngle` degrees (in radians).
     */
    protected double bedAngle;
    /**
     * The max angle of the truck bed (in radians).
     */
    protected double maxBedAngle;

    public void raiseBed(double angle) {
        assert angle >= 0 : "Angle cannot be negative";
        bedAngle = Math.min(bedAngle + angle, maxBedAngle);
    }

    public void lowerBed(double angle) {
        assert angle >= 0 : "Angle cannot be negative";
        bedAngle = Math.max(0, bedAngle - angle);
    }

    public double getBedAngle() {
        return bedAngle;
    }
}
