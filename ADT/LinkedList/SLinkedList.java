package ADT.LinkedList;

import ADT.Ansi;

// MARK: Singly Linked List
public final class SLinkedList<T> {
    Node<T> head;

    // MARK: isEmpty()
    /**
     * Checks if head is NULL
     * ie, Linked List is Empty
     *
     * @return true if empty and false if not
     */
    public boolean isEmpty() {
        return (head == null);
    }

    // MARK: size()
    /**
     * Counts the number of nodes by
     * iterating throughout the Linked List
     *
     * @return count of nodes
     */
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
    /**
     * Adds a node to the end of
     * the Linked List after iterating through it
     *
     * @param info is the info needed to be stored in the Linked List
     */
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

    // MARK: prepend()
    /**
     * Adds a node to the beginning of the Linked List
     *
     * @param info is the info needed to be stored in the Linked List
     */
    public void prepend(T info) {
        Node<T> newNode = new Node<>(info);
        newNode.next = head;
        head = newNode;

    }

    // MARK: insert()
    /**
     * Adds a node at a specified index
     *
     * @param info  is the info needed to be stored in the Linked List
     * @param index is the position to insert info at (indexing used in linked list
     *              is zero indexing). If<br>
     *              1. index is less than, or equal to 0, {@link #prepend()}<br>
     *              2. index is bigger than size of current Linked List,
     *              {@link #append(T)}
     */
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
            newNode.next = cursor;
            cursor = newNode;
        }
    }

    // MARK: deleteBeginning()
    /**
     * Deletes the very first node of the Linked List
     */
    public void deleteBeginning() {
        Node<T> currentNode = head;
        if (!isEmpty()) {
            head = currentNode.next;
        }
    }

    // MARK: deleteEnding()
    /**
     * Deletes the very last node of the Linked List
     */
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
            currentNode.next = null;
        }
    }

    // MARK: delete()
    /**
     * Deletes the node at a given index the Linked List
     *
     * @param index is the position to insert info at (indexing used in linked list
     *              is zero indexing). If<br>
     *              1. index is less than, or equal 0,
     *              {@link #deleteBeginning()}<br>
     *              2. index is bigger than size of current Linked List,
     *              {@link #deleteEnding()}
     */
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
        }
    }

    // MARK: clear()
    /**
     * Empties the current Linked List by setting all nodes to NULL
     */
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
    /**
     * Searches for elem by iterating through Linked List
     *
     * @param elem is the element to search for
     * @return index of the required node and
     *         -1 if elem does not exist in Linked List
     */
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
    /**
     * Returns element at specified index by iterating through Linked List
     *
     * @param index is the index of node to get
     * @return element at specified index
     */
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
     * Iterates through current Linked List and
     * and appends the elements in a new
     * Linked List in the reverse order
     *
     * @return Reversed Linked List
     */
    public SLinkedList<T> reverse() {
        SLinkedList<T> reverseList = this;
        Node<T> previousNode = null;
        Node<T> currentNode = reverseList.head;
        Node<T> tempNext = null;

        while (currentNode != null) {
            tempNext = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = tempNext;
        }
        reverseList.head = previousNode;
        return reverseList;
    }

    // MARK: display
    /**
     * Prints the nodes of current Linked List
     */
    // TODO: pretty print
    public void display() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.info + ", ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // MARK: haha funni
    /**
     * A very important method that is vital for all the above methods
     *
     * @author (Yusra)
     *         <a href=
     *         "https://github.com/Sapphire-Starflower">@Sapphire-Starflower</a>
     */

     public void bint() {
        System.out.println("bogos binted!");
    }

    /**
     * Another very important method that is vital for all the above methods
     *
     * @param s is the string required for the functioning of this method
     *
     * @author (Yusra)
     *         <a href=
     *         "https://github.com/Sapphire-Starflower">@Sapphire-Starflower</a>
     *
     */
    public void bint(String s) {
        System.out.println(s);
    }
}
