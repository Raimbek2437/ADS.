public class MyQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        return list.remove(0);
    }

    public E peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
