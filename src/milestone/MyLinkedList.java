package milestone;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(T item) {
        add(item);
    }

    @Override
    public void set(T item, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode current = get(index);
        current.data = item;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode current = get(index);
            MyNode newNode = new MyNode(item);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new index;

