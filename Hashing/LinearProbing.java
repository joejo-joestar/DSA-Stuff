package Hashing;

import java.util.ArrayList;

class Pair<T> {
    String key;
    T value;
    boolean available;

    public Pair(String k, T v) {
        key = k;
        value = v;
        available = true;
    }
}

@SuppressWarnings("unchecked") // 🤡
public final class LinearProbing<T> {
    Pair<T>[] pairs;
    int capacity, currentSize;

    public LinearProbing(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        // creating an array of a generic is not allowed
        // so we first create an ArrayList of the generic
        // and then convert it to a regular primitive array.
        ArrayList<T> temp = new ArrayList<T>(capacity);
        for (int i = 0; i < capacity; i++) {
            temp.add(null);
        }
        pairs = (Pair<T>[]) temp.toArray();
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
        Pair<T> newPair = new Pair<>(k, v);
        long hashCode = hashFunction(2, k);
        int index = compressionFunction(hashCode);

        Pair<T> temp = pairs[index];

        if (temp == null) {
            pairs[index] = newPair;
            currentSize++;
        }
        for (int i = 1; i < capacity; i++) {
            if (pairs[(index + i) % capacity] == null) {
                pairs[(index + i) % capacity] = newPair;
                break;
            }
        }
        return;
    }

    public Pair<T> search(String k) {
        long hashCode = hashFunction(2, k);
        int index = compressionFunction(hashCode);
        int probeCount = 0;

        while (pairs[index] != null && !k.equals(pairs[index].key) && probeCount < capacity) {
            index = (index + 1) % capacity;
            probeCount++;
        }

        if (pairs[index] != null && probeCount <= capacity) {
            return pairs[index];
        }
        return null;
    }
}
