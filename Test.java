import ADT.*;
// import SortingAlgo.*;
// import ADT.LinkedList.DLinkedList;
import ADT.LinkedList.SLinkedList;

public class Test {
        public static void main(String[] args) {
                System.out.println((-1) % 10);
                String[] ar = { "2", "5", "1csd", "33", "4", "6", "9", "6", "5", "a" };
                // int maxLength = 0;
                // for (String temp : ar) {
                // if (maxLength < temp.length()) {
                // maxLength = temp.length();
                // }
                // }
                // QueueC<String> cq = new QueueC<>(4);
                // for (int i = 0; i < 3; i++) {
                // cq.enqueue(ar[i]);
                // System.out.printf(
                // Ansi.FG_GREEN + "EnQ: " + Ansi.RESET + "%" + maxLength + "s" + Ansi.FG_GREEN
                // + " | " + Ansi.RESET,
                // ar[i]);
                // cq.printQueue();
                // }
                // while (cq.size() > 1) {
                // System.out.printf(
                // Ansi.FG_BLUE + "DQ : " + Ansi.RESET + "%" + maxLength + "s" + Ansi.FG_BLUE +
                // " | " + Ansi.RESET,
                // cq.dequeue());
                // cq.printQueue();
                // }
                // for (int i = 3; i < 5; i++) {
                // cq.enqueue(ar[i]);
                // System.out.printf(
                // Ansi.FG_GREEN + "EnQ: " + Ansi.RESET + "%" + maxLength + "s" + Ansi.FG_GREEN
                // + " | " + Ansi.RESET,
                // ar[i]);
                // cq.printQueue();
                // }
                // while (cq.size() > 0) {
                // System.out.printf(
                // Ansi.FG_BLUE + "DQ : " + Ansi.RESET + "%" + maxLength + "s" + Ansi.FG_BLUE +
                // " | " + Ansi.RESET,
                // cq.dequeue());
                // cq.printQueue();
                // }
                // for (String elem : ar) {
                // cq.enqueue(elem);
                // System.out.printf(
                // Ansi.FG_GREEN + "EnQ: " + Ansi.RESET + "%" + maxLength + "s" + Ansi.FG_GREEN
                // + " | " + Ansi.RESET,
                // elem);
                // cq.printQueue();
                // }
                // for (int i = cq.size(); i >= 0; i--) {
                // System.out.printf(
                // Ansi.FG_BLUE + "DQ : " + Ansi.RESET + "%" + maxLength + "s" + Ansi.FG_BLUE +
                // " | " + Ansi.RESET,
                // cq.dequeue());
                // cq.printQueue();
                // }

                SLinkedList<String> ll = new SLinkedList<>();

                for (int i = 0; i < ar.length; i++) {
                        System.out.printf(
                                        Ansi.FG_GREEN + "Insert: " + Ansi.RESET + "%s" + Ansi.FG_GREEN + " | " +
                                                        Ansi.RESET,
                                        ar[i]);
                        ll.append(ar[i]);
                        ll.display();
                        System.out.println();
                }
                for (int i = 3; i >= 0; i--) {
                        ll.delete(i);
                        ll.display();
                }

                System.out.printf(
                                Ansi.FG_GREEN + "Insert: " + Ansi.RESET + "%s" + Ansi.FG_GREEN + " @ %d | " +
                                                Ansi.RESET,
                                "gs", 4);
                ll.insert("gs", 4);
                ll.prepend("gs");
                ll.display();

                System.out.println("begdel");
                ll.deleteBeginning();
                ll.display();

                System.out.println("enddel");
                ll.deleteEnding();
                ll.display();

                for (int i = 0; i < ar.length; i++) {
                        System.out.printf(
                                        Ansi.FG_GREEN + "Insert: " + Ansi.RESET + "%s" + Ansi.FG_GREEN + " | " +
                                                        Ansi.RESET,
                                        ar[i]);
                        ll.append(ar[i]);
                        ll.display();
                }

                SLinkedList<String> rev = ll.reverse();
                System.out.println("reversed: ");
                rev.display();

                System.out.println(ll.find("1csd"));
                System.out.println(ll.find("4"));
                System.out.println(ll.get(1));
                System.out.println(ll.get(5));
                ll.bint("haha funny");
                ll.bint();

                // ll.clear();
                // System.out.println("ll is ");
                // ll.display();
                // System.out.println(ll.isEmpty());
        }
}
