public interface CanLoadUnordered<T extends Loadable> {
    void Load(T load);

    void Unload(T load);
}
