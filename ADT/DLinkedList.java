package ADT;

// MARK: Singly Linked List
public final class DLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    // MARK: Linked List: isEmpty()
    public boolean isEmpty() {
        return (head == null);
    }

    // MARK: Linked List: size()
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        Node<T> cursor = head;
        int count = 0;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }
        return count;
    }

    // MARK: Linked List: append()
    public void append(T info) {
        Node<T> newNode = new Node<>(info);
        // Create first Node
        if (isEmpty()) {
            head = newNode;
        }
        // Insert at the end
        else {
            Node<T> cursor = head;
            while (cursor.next != null) {
                cursor = cursor.next;
            }
            cursor.next = newNode;
        }
    }

    // MARK: Linked List: insert()
    public void insert(T info, int index) {
        Node<T> newNode = new Node<>(info);
        // Create first Node
        if (isEmpty()) {
            head = newNode;
        }
        // Insert in beginning or at index 0
        else if (index <= 0) {
            newNode.next = head;
            head = newNode;
        }
        // Insert at the end (at index = size() - 1)
        else if (index > size()) {
            append(info);
        }
        // Insert at specified index
        else {
            Node<T> cursor = head;
            int count = 0;
            while (cursor.next != null) {
                if (count == index) {
                    break;
                }
                count++;
                cursor = cursor.next;
            }
            newNode.next = cursor;
            cursor = newNode;
        }
    }
}

