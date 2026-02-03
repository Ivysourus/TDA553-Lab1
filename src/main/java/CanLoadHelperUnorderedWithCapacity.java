public class CanLoadHelperUnorderedWithCapacity<T> extends CanLoadHelper<T> implements CanLoadUnordered<T> {
    private int capacity;

    public CanLoadHelperUnorderedWithCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void Load(Loadable<T> load) {

    }

    public void Unload(Loadable<T> load) {
    }
}
