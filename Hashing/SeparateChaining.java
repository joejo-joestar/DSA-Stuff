package Hashing;

import java.util.ArrayList;

class Node<T> {
    String key;
    T value;
    Node<T> next;

    public Node(String k, T v) {
        key = k;
        value = v;
    }
}

@SuppressWarnings("unchecked") // 🤡
public final class SeparateChaining<T> {
    Node<T>[] bucket;
    int capacity;

    public SeparateChaining(int capacity) {
        this.capacity = capacity;
        // creating an array of a generic is not allowed
        // so we first create an ArrayList of the generic
        // and then convert it to a regular primitive array.
        ArrayList<T> temp = new ArrayList<T>(capacity);
        for (int i = 0; i < capacity; i++) {
            temp.add(null);
        }
        bucket = (Node<T>[]) temp.toArray();
    }

    public long hashFunction(int type, String e) {
        if (type == 1) {
            return componentSum(e);
        }
        if (type == 2) {
            return polynomialHash(e);
        }
        return -1;
    }

    private long polynomialHash(String k) {
        long hashCode = 0;
        long a = 33; // TODO: make global or sm
        for (int i = 0; i < k.length(); i++) {
            hashCode += ((int) Math.pow(a, i) * k.codePointAt(i));
        }
        return hashCode;
    }

    public long componentSum(String k) {
        long hashCode = 0;
        for (int i = 0; i < k.length(); i++) {
            hashCode += k.codePointAt(i);
        }
        return hashCode;
    }

    public int compressionFunction(long hashCode) {
        return (int) (Math.abs(hashCode) % (long) capacity);
    }

    public void insert(String k, T v) {
        Node<T> newNode = new Node<>(k, v);
        long hashCode = hashFunction(2, k);
        int index = compressionFunction(hashCode);

        Node<T> cursor = bucket[index];
        if (cursor == null) {
            bucket[index] = newNode;
            return;
        }
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = newNode;
    }

    public Node<T> find(String k) {
        long hashCode = hashFunction(2, k);
        int index = compressionFunction(hashCode);

        Node<T> cursor = bucket[index];
        while (cursor != null && !cursor.key.equals(k)) {
            cursor = cursor.next;
            return cursor;
        }
        return null;
    }
}