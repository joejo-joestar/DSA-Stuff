package ADT.Queue;

import java.util.ArrayList;
import ADT.Ansi;

// MARK: Circular Queue
@SuppressWarnings("unchecked") // 🤡
public final class CQueue<T> {
    final T[] info;
    int front = 0; // inclusive
    int rear = 0; // exclusive
    final int maxSize;

    /**
     * Constructor to Create an array implemented Circular Queue of a given
     * size.
     * <p>
     * This constructor first creates and ArrayList and then
     * converts it to an Array using the ArrayList.toArray()
     * <p>
     *
     * @param maxSize is the maximum size of the Circular Queue
     * @author (Sreenikethan I)
     *         <a href="https://github.com/SreenikethanI">@SreenikethanI</a>
     * @author (Joseph Cijo)
     *         <a href="https://github.com/joejo-joestar">@joejo-joestar</a>
     *
     */
    public CQueue(int maxSize) {
        this.maxSize = maxSize;

        // creating an array of a generic is not allowed
        // so we first create an ArrayList of the generic
        // and then convert it to a regular primitive array.
        ArrayList<T> temp = new ArrayList<T>(maxSize);
        for (int i = 0; i < maxSize; i++) {
            temp.add(null);
        }
        info = (T[]) temp.toArray();
    }

    // MARK: isEmpty()
    /**
     * Checks if front and rear are at the same index
     * ie, Circular Queue is Empty
     *
     * @return true if empty and false if not
     */
    public boolean isEmpty() {
        return (front == rear);
    }

    // MARK: size()
    /**
     * Does the following equation to find the
     * current size of the Circular Queue
     * {@snippet :
     * (maxSize - front + rear) % maxSize // @highlight substring = "(maxSize - front + rear) % maxSize" type = "italic"
     * }
     *
     * @return current size of Circular Queue
     */
    public int size() {
        if (!isEmpty()) {
            return ((maxSize - front + rear) % maxSize);
        }
        return 0;
    }

    // MARK: isFull()
    /**
     * Simply checks if the current Circular Queue is Full or Not
     *
     * @return true if empty and false if not
     */
    public boolean isFull() {
        return (size() == maxSize);
    }

    // MARK: enqueue()
    /**
     * Inserting (Enqueueing) element into the rear of the Circular Queue.
     * <p>
     * <strong>Here, rear is an index.</strong>
     * <p>
     * Also increments rear using the below code snippet:
     * {@snippet :
     * rear = (rear + 1) % maxSize // @highlight substring = "rear = (rear + 1) % maxSize" type = "italic"
     * }
     *
     * @param elem the element to enqueue
     */
    public void enqueue(T elem) {
        // Overflow Condition
        if (isFull()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Circular Queue is Full" + Ansi.RESET);
            return;
        } else {
            info[rear] = elem;
            rear = (rear + 1) % maxSize;
        }
    }

    // MARK: peek()
    /**
     * Shows the element that will be dequeued next (element at front)
     * <p>
     * <strong>Here, front is an index.</strong>
     *
     * @return the element at front
     */
    public T peek() {
        if (!isEmpty()) {
            return info[front];
        }
        return null;
    }

    // MARK: dequeue()
    /**
     * Shows the element at front and removes it from the queue.
     * <p>
     * <strong>Here, front is an index.</strong>
     * <p>
     * Also increments front using the below code snippet:
     * {@snippet :
     * front = (front + 1) % maxSize // @highlight substring = "front = (front + 1) % maxSize" type = "italic"
     * }
     *
     * @return the element at front
     */
    public T dequeue() {
        T temp = null;
        // Underflow Condition
        if (isEmpty()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Circular Queue is Empty" + Ansi.RESET);
        } else {
            temp = this.info[front];
            front = (front + 1) % maxSize;
        }
        return temp;
    }

    // MARK: printQueue()
    /**
     *
     * Prints the Queue with front and rear indices in Ansi colors.
     * <p>
     * Print Format: [front = i | rear = j] [e1 , e2, e3...]
     *
     */
    public void printQueue() {
        // for displaying front and rear of queue
        int maxDigits = String.valueOf(maxSize).length();
        System.out.printf(
                Ansi.FG_BRIGHT_CYAN + "[" + Ansi.FG_BRIGHT_YELLOW + "front = %" + ((maxDigits >= 2) ? maxDigits : 2)
                        + "s " + Ansi.FG_BRIGHT_CYAN + " | " + Ansi.FG_BRIGHT_YELLOW
                        + "rear  = %" + ((maxDigits >= 2) ? maxDigits : 2)
                        + "s"
                        + Ansi.FG_BRIGHT_CYAN + "] "
                        + Ansi.RESET,
                String.valueOf(front), String.valueOf(rear));
        System.out.print(Ansi.FG_BRIGHT_GREEN + "[" + Ansi.RESET);

        // displaying elements
        String separator = Ansi.FG_YELLOW + ", " + Ansi.RESET;
        for (int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.print(info[i] + separator);
        }
        System.out.println(Ansi.FG_BRIGHT_GREEN + "]" + Ansi.RESET);
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
