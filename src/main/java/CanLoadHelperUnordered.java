public class CanLoadHelperUnordered<T extends Loadable> extends CanLoadHelper<T> implements CanLoadUnordered<T> {
    public CanLoadHelperUnordered(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void load(T load) {

    }

    @Override
    public void unload(T load) {
    }
}
