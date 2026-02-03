import java.util.ArrayList;

public abstract class CanLoadHelper<T extends Loadable> {
    protected final ArrayList<T> cargo = new ArrayList<>();

    public void Load(T load) {
        cargo.add(load);
    }
}
