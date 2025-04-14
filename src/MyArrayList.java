public class MyArrayList<E> implements MyList<E> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    @Override
    public void add(E element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removed = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            int index = 0;
            public boolean hasNext() {
                return index < size;
            }
            public E next() {
                return (E) data[index++];
            }
        };
    }
}
