import java.util.Arrays;
import java.util.Stack;

public class TaskList {

    void task1() {
        System.out.println("Task1");
        System.out.println("Примерами использования сортировки являются: " +
                "рекурсивный бинарный поиск, рекурсивная сортировка слиянием и т. п.");
    }

    void task2() {
        System.out.println("\nTask2");
//        infinityRecursion(0);
        finiteRecursion(0, 100);
    }

    void task3() {
        System.out.println("\n\nTask3");
        System.out.println("Примеры, изображающий стек: стопка полотенец, из которой можно " +
                "взять только верхнее полотенце, не разрушив стопку, java.util.Stack");
        System.out.println("Примеры, изображающий рекурсивный стек: стек вызовов при " +
                "вычисление факториала, стек вызовов рекрсивной функции");
    }

    void task4and5(int[] arr, int elem) {
        System.out.println("\nTask4 and 5");
        System.out.printf("Времени затрачено на бинарный элемента %s в массиве из %s элементов: %s\n", elem, arr.length, Utills.time(() -> {
            System.out.printf("Индекс искомого элемента: %s\n", binarySearch(arr, elem));
        }));

        System.out.printf("Времени затрачено на рекурсивный бинарный поиск элемента %s в массиве из %s элементов: %s\n", elem, arr.length, Utills.time(() -> {
            System.out.printf("Индекс искомого элемента: %s\n", binaryRecursionSearch(arr, 6, 0, arr.length - 1));
        }));
    }

    void task6(int[] arr) {
        System.out.println("\nTask6");
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        System.out.printf("Времени затрачено на рекурсивную сортировку массива из %s элементов: %s\n", arr.length, Utills.time(() -> {
            mergeSort(arr, 0, (arr.length - 1));
        }));

        System.out.printf("Времени затрачено на быструю сортировку массива из %s элементов: %s\n", arr1.length, Utills.time(() -> {
            Arrays.sort(arr1);
        }));
    }

    int infinityRecursion(int counter) {
        System.out.println(counter++);
        return infinityRecursion(counter);
    }

    int finiteRecursion(int counter, int limit) {
        while (counter < limit) {
            System.out.printf("%s, ", counter);
            return finiteRecursion(++counter, limit);
        }
        return counter;
    }

    int binarySearch(int[] arr, int elem) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        int middleIndex;

        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elem) return middleIndex;
            if (arr[middleIndex] < elem) firstIndex = ++middleIndex;
            else if (arr[middleIndex] > elem) lastIndex = --middleIndex;
        }
        return -1;
    }

    int binaryRecursionSearch(int[] arr, int elem, int firstIndex, int lastIndex) {
        int middleIndex;
        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elem) return middleIndex;
            if (arr[middleIndex] < elem) return binaryRecursionSearch(arr, elem, ++middleIndex, lastIndex);
            else if (arr[middleIndex] > elem) return binaryRecursionSearch(arr, elem, firstIndex, --middleIndex);
        }
        return -1;
    }

    void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    void merge(int[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int leftArray[] = new int[lengthLeft];
        int rightArray[] = new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
