public abstract class PersonCar extends Car implements Loadable {
    public void setPosition(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getPosition() {
        return new Vector2(pos);
    }
}
