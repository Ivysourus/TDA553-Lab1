public class Workshop<T extends Car> implements CanLoadUnordered<T> {
    private final CanLoadHelperUnordered<T> canLoadHelper;

    public Workshop(int capacity) {
        canLoadHelper = new CanLoadHelperUnordered<>(capacity);
    }

    @Override
    public void load(T load) {
        load.stopEngine();
        canLoadHelper.load(load);
    }

    @Override
    public void unload(T load) {
        canLoadHelper.unload(load);
    }
}
