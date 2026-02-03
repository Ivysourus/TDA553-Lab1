public interface CanLoadOrdered<T> {
    void Load(Loadable<T> load);

    Loadable<T> Unload();
}
