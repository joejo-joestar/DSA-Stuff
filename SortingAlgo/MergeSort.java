package SortingAlgo;

import java.util.ArrayList;

public class MergeSort<T extends Comparable> {
    T[] array;

    // MARK: constructor
    public MergeSort(T[] array) {
        this.array = array;
    }

    // MARK: sorting ascending
    public T[] sortAscending(int low, int high) {
        if (low < high) {
            int mid = (high + low - 1) / 2;
            sortAscending(low, mid);
            sortAscending(mid + 1, high);
            mergeAscending(low, mid, high);
        }
        return array;
    }

    // MARK: merging ascending
    private void mergeAscending(int low, int mid, int high) {
        int countIndex = 0;
        int left = low;
        int right = mid + 1;
        int size = high - low + 1;

        // creating an array of a generic is not allowed
        // so we first create an ArrayList of the generic
        // and then convert it to a regular primitive array.
        ArrayList<T> temp = new ArrayList<T>(size);
        for (int i = 0; i < size; i++) {
            temp.add(null);
        }
        T[] auxArr = (T[]) temp.toArray();

        while (left <= mid && right <= high) {
            if (array[left].compareTo(array[right]) < 0) {
                auxArr[countIndex] = array[left];
                left++;
            } else {
                auxArr[countIndex] = array[right];
                right++;
            }
            countIndex++;
        }

        while (right <= high) {
            auxArr[countIndex] = array[right];
            right++;
            countIndex++;
        }

        while (left <= mid) {
            auxArr[countIndex] = array[left];
            left++;
            countIndex++;
        }

        for (int i = 0; i < size; i++) {
            array[i + low] = auxArr[i];
        }
    }

    // MARK: sorting descending
    public T[] sortDescending(int low, int high) {
        if (low < high) {
            int mid = (high + low - 1) / 2;
            sortDescending(low, mid);
            sortDescending(mid + 1, high);
            mergeDescending(low, mid, high);
        }
        return array;
    }

    // MARK: merging descending
    private void mergeDescending(int low, int mid, int high) {
        int countIndex = 0;
        int left = low;
        int right = mid + 1;
        int size = high - low + 1;

        // creating an array of a generic is not allowed
        // so we first create an ArrayList of the generic
        // and then convert it to a regular primitive array.
        ArrayList<T> temp = new ArrayList<T>(size);
        for (int i = 0; i < size; i++) {
            temp.add(null);
        }
        T[] auxArr = (T[]) temp.toArray();

        while (left <= mid && right <= high) {
            if (array[left].compareTo(array[right]) > 0) {
                auxArr[countIndex] = array[left];
                left++;
            } else {
                auxArr[countIndex] = array[right];
                right++;
            }
            countIndex++;
        }

        while (right <= high) {
            auxArr[countIndex] = array[right];
            right++;
            countIndex++;
        }

        while (left <= mid) {
            auxArr[countIndex] = array[left];
            left++;
            countIndex++;
        }

        for (int i = 0; i < size; i++) {
            array[i + low] = auxArr[i];
        }
    }

    // MARK: goofy aah bint
    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }
}
