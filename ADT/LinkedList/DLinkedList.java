package ADT.LinkedList;

import ADT.Ansi;

// MARK: Doubly Linked List
public final class DLinkedList<T> {
    Node<T> head;
    // Node<T> tail;

    // MARK: isEmpty()
    public boolean isEmpty() {
        return (head == null);
    }

    // MARK: size()
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

    // MARK: append()
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
            newNode.previous = cursor;
        }
    }

    // MARK: prepend()
    public void prepend(T info) {
        Node<T> newNode = new Node<>(info);
        // Create first Node
        if (isEmpty()) {
            head = newNode;
        }
        // Insert at the beginning
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    // MARK: insert()
    public void insert(T info, int index) {
        Node<T> newNode = new Node<>(info);
        // Create first Node
        if (isEmpty()) {
            head = newNode;
        }
        // Insert in beginning or at index 0
        else if (index <= 0) {
            prepend(info);
        }
        // Insert at the end (at index = size() - 1)
        else if (index > size()) {
            append(info);
        }
        // Insert at specified index
        else {
            Node<T> cursor = head;
            int count = 0;
            while (cursor.next != null && count != index) {
                count++;
                cursor = cursor.next;
            }
            cursor.previous.next = newNode;
            newNode.next = cursor;
            newNode.previous = cursor.previous;
            cursor.previous = newNode;
        }
    }

    // MARK: deleteBeginning()
    public void deleteBeginning() {
        Node<T> currentNode = head;
        if (!isEmpty()) {
            head = currentNode.next;
        } else {
            System.out.println(Ansi.FG_BRIGHT_RED + "Linked List is Empty" + Ansi.RESET);
            return;
        }
    }

    // MARK: deleteEnd()
    public void deleteEnding() {
        Node<T> currentNode = head;
        if (isEmpty()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Linked List is Empty" + Ansi.RESET);
            return;
        }
        if (currentNode.next == null) {
            head = null;
        } else {
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next.previous = currentNode;
            currentNode.next = null;
        }
    }

    public void delete(int index) {
        Node<T> currentNode = head;
        int count = 0;
        if (isEmpty()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Linked List is Empty" + Ansi.RESET);
            return;
        }
        if (index <= 0) {
            deleteBeginning();
        } else if (index >= size()) {
            deleteEnding();
        } else {
            while (currentNode.next != null && (index - 1) != count) {
                count++;
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.previous = currentNode;
        }
    }

    // MARK: clear()
    public void clear() {
        Node<T> currentNode = head;
        Node<T> temp = currentNode.next;
        while (currentNode != null) {
            temp = currentNode.next;
            currentNode.next = null;
            currentNode = temp;
        }
        head = null;
    }

    // MARK: find()
    public int find(T elem) {
        if (isEmpty()) {
            return -1;
        }
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null && !currentNode.info.equals(elem)) {
            currentNode = currentNode.next;
            index++;
        }
        return index;
    }

    // MARK: get()
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node<T> currentNode = head;
        int count = 0;
        while (currentNode != null && index != count) {
            count++;
            currentNode = currentNode.next;
        }
        return currentNode.info;
    }

    // MARK: reverse()

    /**
     * the reverse() method returns a
     * new linked list with reversed elements
     */
    public DLinkedList<T> reverse() {
        DLinkedList<T> reverseList = new DLinkedList<>();
        Node<T> cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        while (cursor.next != head) {
            reverseList.append(cursor.info);
            cursor = cursor.previous;
        }
        return reverseList;
    }

    // MARK: display
    // TODO: pretty print
    public void display() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.info + ", ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // credits: (Yusra) @Sapphire-Starflower
    // MARK: haha funni
    public void bint() {
        System.out.println("bogos binted!");
    }

    public void bint(String s) {
        System.out.println(s);
    }
}
