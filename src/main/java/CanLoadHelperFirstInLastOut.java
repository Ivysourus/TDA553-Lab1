import java.util.Optional;

public class CanLoadHelperFirstInLastOut<T> extends CanLoadHelper<T> implements CanLoadOrdered<T> {

    public Optional<Loadable<T>> Unload() {
        if (cargo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cargo.remove(-1));
    }
}
