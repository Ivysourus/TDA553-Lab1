import java.util.Optional;

public interface CanLoadOrdered<T extends Loadable> {
    void load(T load);

    Optional<T> unload();
}
