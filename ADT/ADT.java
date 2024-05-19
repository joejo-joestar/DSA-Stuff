package ADT;

// MARK: Node
class Node<T> {
    Node<T> previous;
    T info;
    Node<T> next;

    Node(T info) {
        this.info = info;
        next = null;
    }
}

// MARK: Singly Linked List
class SLinkedList<T> {
    Node<T> head;

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

// MARK: Stack
class Stack<T> {
    T[] info;
    int top;
    int size;
    int maxSize;

    Stack(T[] info) {
        this.info = info;
        top = -1;
        maxSize = info.length;
    }

    // MARK: Stack: isEmpty()
    public boolean isEmpty() {
        return (top == -1);
    }

    // MARK: Stack: isEmpty()
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // MARK: Stack: size()
    public int size() {
        return size;
    }

    // MARK: Stack: push()
    public void push(T elem) {
        if (isFull()) {
            System.out.println(Ansi.FG_RED + "Stack is Full" + Ansi.RESET);
            return;
        }
        info[++top] = elem;
        size++;
    }

    // MARK: Stack: peek()
    public T peek() {
        if (!isEmpty()) {
            return info[top];
        }
        return null;
    }

    // MARK: Stack: pop()
    public T pop() {
        // Underflow Condition
        if (isEmpty()) {
            System.out.println(Ansi.FG_RED + "Stack is Empty" + Ansi.RESET);
            return null;
        }
        size--;
        T temp = this.info[top];
        top--;
        return temp;
    }
}

// MARK: Queue
class Queue<T> {
    T[] info;
    int front;
    int rear;
    int size;
    int maxSize;

    Queue(T[] info) {
        this.info = info;
        front = -1;
        rear = -1;
        maxSize = info.length;
    }

    // MARK: Queue: isEmpty()
    public boolean isEmpty() {
        return (front == -1 || rear == -1);
    }

    // MARK: Queue: isFull()
    public boolean isFull() {
        return (rear == maxSize - 1);
    }

    // MARK: Queue: size()
    public int size() {
        return size;
    }

    // MARK: Queue: enqueue()
    public void enqueue(T elem) {
        // Overflow Condition
        if (isFull()) {
            System.out.println(Ansi.FG_RED + "Queue is Full" + Ansi.RESET);
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }
        info[rear] = elem;
        size++;
    }

    // MARK: Queue: peek()
    public T peek() {
        if (!isEmpty()) {
            return info[front];
        }
        return null;
    }

    // MARK: Queue: dequeue()
    public T dequeue() {
        // Underflow Condition
        if (isEmpty()) {
            System.out.println(Ansi.FG_RED + "Queue is Empty" + Ansi.RESET);
            return null;
        }
        T temp = null;
        if (rear == front) {
            rear = -1;
            front = -1;
        } else {
            temp = this.info[front];
            front--;
            size--;
        }
        return temp;
    }
}

// MARK: Circular Queue
class CQueue<T> {
    T[] info;
    int front;
    int rear;
    int size;
    int maxSize;

    CQueue(T[] info) {
        this.info = info;
        front = -1;
        rear = -1;
        size = info.length;
        maxSize = info.length;
    }

    // MARK: Circular Queue: isEmpty()
    public boolean isEmpty() {
        return (front == rear);
    }

    // MARK: Circular Queue: isFull()
    public boolean isFull() {
        return (rear == maxSize - 1);
    }

    // MARK: Circular Queue: size()
    public int size() {
        return size;
    }

    // MARK: Circular Queue: enqueue()
    public void enqueue(T elem) {
        // Overflow Condition
        if (isFull()) {
            System.out.println(Ansi.FG_RED + "Circular Queue is Full" + Ansi.RESET);
            return;
        } else {
            info[rear] = elem;
            rear = (rear + 1) % maxSize;
            size++;
        }
    }

    // MARK: Circular Queue: peek()
    public T peek() {
        if (!isEmpty()) {
            return info[front];
        }
        return null;
    }

    // MARK: Circular Queue: dequeue()
    public T dequeue() {
        // Underflow Condition
        T temp = null;
        if (isEmpty()) {
            System.out.println(Ansi.FG_RED + "Circular Queue is Empty" + Ansi.RESET);
        } else {
            temp = this.info[front];
            front = (front + 1) % maxSize;
            size--;
        }
        return temp;
    }
}

// MARK: TODO:
// TODO: Doubly Linked List
// TODO: Heap
// TODO: AVL Tree