package ADT;

import java.util.*;

// MARK: Stack
@SuppressWarnings("unchecked") // 🤡
public final class Stack<T> {
    final T[] info;
    final int maxSize;
    int top = -1; // inclusive

    /**
     * Constructor to Create an array implemented Stack of a given
     * size.
     * <p>
     * This constructor first creates and ArrayList and then
     * converts it to an Array using the ArrayList.toArray()
     * <p>
     *
     * @param maxSize is the maximum size of the Stack
     * @author (Sreenikethan I)
     *         <a href="https://github.com/SreenikethanI">@SreenikethanI</a>
     * @author (Joseph Cijo)
     *         <a href="https://github.com/joejo-joestar">@joejo-joestar</a>
     *
     */

    public Stack(int maxSize) {
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

    // MARK: Stack: isEmpty()
    public boolean isEmpty() {
        return (top == -1);
    }

    // MARK: Stack: isFull()
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // MARK: Stack: size()
    public int size() {
        return (top + 1);
    }

    // MARK: Stack: push()
    public void push(T elem) {
        if (isFull()) {
            System.out.println(Ansi.FG_BRIGHT_RED + "Stack is Full" + Ansi.RESET);
            return;
        }
        top++;
        info[top] = elem;
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
            System.out.println(Ansi.FG_BRIGHT_RED + "Stack is Empty" + Ansi.RESET);
            return null;
        }
        T temp = this.info[top];
        top--;
        return temp;
        // return this.info[top--];
    }

    // MARK: Stack: printStack()
    public void printStack() {
        int maxDigits = String.valueOf(maxSize).length();
        String separator = Ansi.FG_YELLOW + ", " + Ansi.RESET;
        System.out.printf(
                Ansi.FG_BRIGHT_CYAN + "[" + Ansi.FG_BRIGHT_YELLOW + "top = %" + ((maxDigits >= 2) ? maxDigits : 2) + "s"
                        + Ansi.FG_BRIGHT_CYAN + "] "
                        + Ansi.RESET,
                String.valueOf(top));
        System.out.print(Ansi.FG_BRIGHT_GREEN + "[" + Ansi.RESET);
        for (int i = 0; i < top; i++) {
            System.out.print(info[i] + separator);
        }
        if (top < 0) {
            System.out.print(Ansi.FG_BRIGHT_GREEN + "]" + Ansi.RESET);
        } else {
            System.out.print(info[top] + Ansi.FG_BRIGHT_GREEN + "]" + Ansi.RESET);
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
