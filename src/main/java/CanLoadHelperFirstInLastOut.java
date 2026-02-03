public class CanLoadHelperFirstInLastOut<T> extends CanLoadHelper<T> implements CanLoadOrdered<T> {
    public void Load(Loadable<T> load) {
    }

    public Loadable<T> Unload() {
    }
}
