import java.util.ArrayList;

public abstract class CanLoadHelper<T> {
    protected final ArrayList<Loadable<T>> cargo = new ArrayList<Loadable<T>>();

    public void Load(Loadable<T> load) {
        cargo.add(load);
    }
}

