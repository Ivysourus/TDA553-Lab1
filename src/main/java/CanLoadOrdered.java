import java.util.Optional;

public interface CanLoadOrdered<T> {
    void Load(Loadable<T> load);

    Optional<Loadable<T>> Unload();
}
