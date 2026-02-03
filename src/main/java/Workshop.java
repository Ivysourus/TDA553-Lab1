public class Workshop<T extends Loadable> implements CanLoadUnordered<T> {
    private final CanLoadHelperUnorderedWithCapacity<T> canLoadHelper;

    public Workshop(int capacity) {
        canLoadHelper = new CanLoadHelperUnorderedWithCapacity<>(capacity);

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
