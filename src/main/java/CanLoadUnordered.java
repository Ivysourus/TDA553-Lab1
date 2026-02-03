public interface CanLoadUnordered<T> {
    void Load(Loadable<T> load);

    void Unload(Loadable<T> load);
}
