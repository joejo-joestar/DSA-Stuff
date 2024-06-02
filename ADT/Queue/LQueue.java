package ADT.Queue;

import java.util.*;

import ADT.Ansi;

// MARK: Queue
@SuppressWarnings("unchecked") // 🤡
public final class LQueue<T> {
    final T[] info;
    final int maxSize;
    int front = 0; // inclusive
    int rear = 0; // exclusive

    /**
     * Constructor to Create an array implemented Queue of a given
     * size.
     * <p>
     * This constructor first creates and ArrayList and then
     * converts it to an Array using the ArrayList.toArray()
     * <p>
     *
     * @param maxSize is the maximum size of the Queue
     * @author (Sreenikethan I)
     *         <a href="https://github.com/SreenikethanI">@SreenikethanI</a>
     * @author (Joseph Cijo)
     *         <a href="https://github.com/joejo-joestar">@joejo-joestar</a>
     *
     */
    public LQueue(int maxSize) {
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
     * ie, Queue is Empty
     *
     * @return true if empty and false if not
     */
    public boolean isEmpty() {
        return (front == rear);
    }

    // MARK: isFull()
    /**
     * Simply checks if the current Queue is Full or Not
     *
     * @return true if empty and false if not
     */
    public boolean isFull() {
        return (rear == maxSize);
    }

    // MARK: size()
    /**
     * Returns current size of Queue
     *
     * @return current size of Queue
     */
    public int size() {
        return (rear - front);
    }

    // MARK: enqueue()
    /**
     * Inserting (Enqueueing) element into the rear of the Queue.
     * <p>
     * <strong>Here, rear is not an index.</strong>
     * <p>
     *
     * @param elem the element to enqueue
     */
    public void enqueue(T elem) {
        // Overflow Condition
        if (isFull()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Queue is Full" + Ansi.RESET);
            return;
        }
        info[rear] = elem;
        rear++;
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
     *
     * @return the element at front
     */

    public T dequeue() {
        // Underflow Condition
        if (isEmpty()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Queue is Empty" + Ansi.RESET);
            return null;
        }
        T temp = this.info[front];
        front++;
        if (isEmpty()) {
            // reset front and rear back to 0, so that we start with a
            // fresh empty queue with full capacity
            rear = 0;
            front = 0;
        }
        return temp;
    }

    // MARK: printQueue()
    /**
     *
     * Prints the Queue wih front and rear indices in Ansi colors.
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
        for (int i = front; i < rear - 1; i++) {
            System.out.print(info[i] + separator);
        }
        if (rear <= 0) {
            System.out.println(Ansi.FG_BRIGHT_GREEN + "]" + Ansi.RESET);
        } else {
            System.out.println(info[rear - 1] + Ansi.FG_BRIGHT_GREEN + "]" + Ansi.RESET);
        }
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
