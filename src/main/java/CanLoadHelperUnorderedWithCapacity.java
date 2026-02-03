public class CanLoadHelperUnorderedWithCapacity<T extends Loadable> extends CanLoadHelper<T> implements CanLoadUnordered<T> {
    private int capacity;

    public CanLoadHelperUnorderedWithCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void load(T load) {

    }

    @Override
    public void unload(T load) {
    }
}
