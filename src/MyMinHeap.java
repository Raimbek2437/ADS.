public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> heap = new MyArrayList<>();

    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public E removeMin() {
        if (heap.size() == 0) return null;
        E min = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heapifyDown(0, last);
        }
        return min;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index, E element) {
        int size = heap.size();
        while (index * 2 + 1 < size) {
            int left = index * 2 + 1;
            int right = left + 1;
            int smallest = left;

            if (right < size && heap.get(right).compareTo(heap.get(left)) < 0) {
                smallest = right;
            }

            if (element.compareTo(heap.get(smallest)) <= 0) break;

            heap.get(index); // dummy line to avoid error in swap()
            swap(index, smallest);
            index = smallest;
        }
        heap.add(index, element);  // reinsert at correct position
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.remove(i);
        heap.add(i, heap.get(j - 1)); // tricky part since remove(i) shifts elements
        heap.remove(j);
        heap.add(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}
