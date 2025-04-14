public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void add(T item, int index);
    T get(int index);
    T remove(int index);
    boolean remove(T item);
    void clear();
    int size();
    boolean contains(T item);
    void sort();
}