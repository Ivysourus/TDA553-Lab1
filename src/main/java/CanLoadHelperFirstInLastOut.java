import java.util.Optional;

public class CanLoadHelperFirstInLastOut<T extends Loadable> extends CanLoadHelper<T> implements CanLoadOrdered<T> {
    @Override
    public Optional<T> unload() {
        if (cargo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cargo.remove(-1));
    }
}
