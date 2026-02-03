public abstract class Truck extends Car {
    /**
     * The angle of the bed, from 0-70 degrees (in radians).
     */
    protected double angle;

    public void raiseBed(double angle) {
        assert angle >= 0 : "Angle cannot be negative";
        this.angle = Math.min(this.angle + angle, (7.0/18.0)*Math.PI);
    }
    public void lowerBed(double angle) {
        assert angle >= 0 : "Angle cannot be negative";
        this.angle = Math.min(this.angle - angle, (7.0/18.0)*Math.PI);
    }
}