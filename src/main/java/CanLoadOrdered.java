import java.util.Optional;

public interface CanLoadOrdered<T extends Loadable> {
    void Load(T load);

    Optional<T> Unload();
}
