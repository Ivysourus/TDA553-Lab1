import java.util.ArrayList;

public abstract class CanLoadHelper<T> {
    protected final ArrayList<Loadable<T>> load = new ArrayList<Loadable<T>>();
}
