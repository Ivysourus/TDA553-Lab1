public interface CanLoadUnordered<T extends Loadable> {
    void load(T load);

    void unload(T load);
}
