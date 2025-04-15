public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E data;
        MyNode next, prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head, tail;
    private int size;

    @Override
    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public E remove(int index) {
        MyNode node = getNode(index);
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
        return node.data;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
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
        head = tail = null;
        size = 0;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            MyNode current = head;
            public boolean hasNext() {
                return current != null;
            }
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
