import java.util.Optional;

public class CanLoadHelperFirstInFirstOut<T extends Loadable> extends CanLoadHelper<T> implements CanLoadOrdered<T> {
    public CanLoadHelperFirstInFirstOut(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Optional<T> unload() {
        if (cargo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cargo.removeFirst());
    }
}
