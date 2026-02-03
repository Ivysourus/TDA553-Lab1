public class Workshop<T extends Loadable> implements CanLoadUnordered<T> {
    private final CanLoadHelperUnordered<T> canLoadHelper;

    public Workshop(int capacity) {
        canLoadHelper = new CanLoadHelperUnordered<>(capacity);

        //If len(workshop) =! capacity:
            //Workshop.add(car)
    }

    @Override
    public void load(T load) {
    }

    @Override
    public void unload(T load) {
    }
}
