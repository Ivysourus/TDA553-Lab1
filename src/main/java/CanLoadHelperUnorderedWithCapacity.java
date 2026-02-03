public class CanLoadHelperUnorderedWithCapacity<T extends Loadable> extends CanLoadHelper<T> implements CanLoadUnordered<T> {
    private int capacity;

    public CanLoadHelperUnorderedWithCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void Load(T load) {

    }

    public void Unload(T load) {
    }
}
