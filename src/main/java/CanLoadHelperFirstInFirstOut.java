import java.util.Optional;

public class CanLoadHelperFirstInFirstOut<T extends Loadable> extends CanLoadHelper<T> implements CanLoadOrdered<T> {
    @Override
    public Optional<T> Unload() {
        if (cargo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cargo.removeFirst());
    }
}
