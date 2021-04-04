package Heap;

public class Heap<T extends Comparable> {
    int heapSize;

    public void sort(T[] arr) {
        buildHeap(arr);
        while (heapSize > 1) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, 0);
        }
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void heapify(T[] arr, int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest = i;

        if (left < heapSize && arr[i].compareTo(arr[left]) < 0) {
            largest = left;
        }
        if (right < heapSize && arr[largest].compareTo(arr[right]) < 0) {
            largest = right;
        }
        if (i != largest) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    private void buildHeap(T[] arr) {
        heapSize = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }
}
