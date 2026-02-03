public class Workshop<T> implements CanLoadUnordered<T> {
    private CanLoadHelperUnorderedWithCapacity<T> canLoadHelper;

    public Workshop(int capacity) {
    }

    public void Load(Loadable<T> load) {
    }

    public void Unload(Loadable<T> load) {
    }
}
