import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static long start;
    static long time;
    static long sortTime;
    static long bubbleTime;
    static long chooseTime;
    static long pasteTime;

    public static void main(String[] args) {
        task1();
        task2();
        int[] arr = createAndFillArr(400);
        task3(arr);
        task4(arr);
        task5(arr);
        task6(arr);
    }

    public static void task1() {
        System.out.println("//Task1");
        final int numberOfCopies = 50;

        int[] arr = createAndFillArr(numberOfCopies);
        int[] arrCopy;

        start = System.nanoTime();
        arrCopy = Arrays.copyOf(arr, arr.length);
        time = System.nanoTime() - start;

        System.out.printf("Копирование массива размером %d методом Arrays.copyOf() заняло %s, nanos\n", numberOfCopies, time);

        start = System.nanoTime();
        boolean b = Arrays.equals(arr, arrCopy);
        time = System.nanoTime() - start;

        System.out.printf("Сравнение массивов размером %d методом Arrays.equals() заняло %s, nanos. Результат: %b\n", numberOfCopies, time, b);

        start = System.nanoTime();
        Arrays.sort(arr);
        time = System.nanoTime() - start;

        System.out.printf("Сортировка массива размером %d методом Arrays.sort() заняло %s, nanos\n", numberOfCopies, time);

        int[] arrToFill = new int[numberOfCopies];
        printArr(arrToFill);

        start = System.nanoTime();
        Arrays.fill(arrToFill, 1);
        time = System.nanoTime() - start;

        printArr(arrToFill);
        System.out.printf("Заполнение массива размером %d методом Arrays.fill() заняло %s, nanos\n", numberOfCopies, time);

    }

    public static void task2() {
        System.out.println("\n//Task2");
        final int numberOfCopies = 1000;
        Random r = new Random();
        int elem = r.nextInt(numberOfCopies);
        int[] arr = createAndFillArr(numberOfCopies);
        Arrays.sort(arr);

        start = System.nanoTime();
        int result = search(arr, elem);
        time = System.nanoTime() - start;

        System.out.printf("поиск элемента %s в массиве размером %d линейным поиском заняло %s, " +
                "nanos. Номер элемента: %s\n", elem, numberOfCopies, time, result);

        start = System.nanoTime();
        int result1 = binarySearch(arr, elem);
        time = System.nanoTime() - start;

        System.out.printf("поиск элемента %s в массиве размером %d бинарным поиском заняло %s, " +
                "nanos. Номер элемента: %s\n", elem, numberOfCopies, time, result1);
    }

    public static int[] task3(int[] arr) {
        System.out.println("\n//Task3");
        int[] alteredArr = Arrays.copyOf(arr, arr.length);

        start = System.nanoTime();
        Arrays.sort(alteredArr);
        sortTime = System.nanoTime() - start;

        System.out.printf("Сортировка массива размером %d методом Arrays.sort() заняло %s, nanos\n", arr.length, sortTime);
        printArr(arr);
        printArr(alteredArr);
        return alteredArr;
    }

    public static int[] task4(int[] arr) {
        System.out.println("\n//Task4");
        int[] alteredArr = Arrays.copyOf(arr, arr.length);

        start = System.nanoTime();
        for (int i = alteredArr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (alteredArr[j] > alteredArr[j + 1]) swapElems(alteredArr, j, j + 1);
            }
        }
        bubbleTime = System.nanoTime() - start;

        System.out.printf("Сортировка массива размером %d пузырьком заняло %s, nanos.\n" +
                "Сортировка того же массива методом Arrays.sort() заняло %s, nanos\n", alteredArr.length, bubbleTime, sortTime);
        printArr(arr);
        printArr(alteredArr);
        return alteredArr;
    }

    public static int[] task5(int[] arr) {
        System.out.println("\n//Task5");
        int[] alteredArr = Arrays.copyOf(arr, arr.length);

        start = System.nanoTime();
        for (int i = 0; i < alteredArr.length; i++) {
            int min = i;
            for (int j = i + 1; j < alteredArr.length; j++) {
                if (alteredArr[j] < alteredArr[min]) min = j;
            }
            swapElems(alteredArr, i, min);
        }
        chooseTime = System.nanoTime() - start;

        System.out.printf("Сортировка массива размером %d выбором заняло %s, nanos.\n" +
                "Сортировка того же массива методом Arrays.sort() заняло %s, nanos.\n" +
                "Сортировка того же массива пузырьком заняло %s, nanos.\n", alteredArr.length, chooseTime, sortTime, bubbleTime);
        printArr(arr);
        printArr(alteredArr);
        return alteredArr;
    }

    public static int[] task6(int[] arr) {
        System.out.println("\n//Task6");
        int[] alteredArr = Arrays.copyOf(arr, arr.length);

        start = System.nanoTime();
        int index;
        int tmp;
        for (int i = 1; i < alteredArr.length; i++) {
            tmp = alteredArr[i];
            index = i;
            while (index > 0 && alteredArr[index - 1] >= tmp) {
                alteredArr[index] = alteredArr[index - 1];
                index--;
            }
            alteredArr[index] = tmp;
        }
        pasteTime = System.nanoTime() - start;

        System.out.printf("Сортировка массива размером %d вставкой заняло %s, nanos.\n" +
                "Сортировка того же массива методом Arrays.sort() заняло %s, nanos.\n" +
                "Сортировка того же массива пузырьком заняло %s, nanos.\n" +
                "Сортировка того же массива выбором заняло %s, nanos.\n", alteredArr.length, pasteTime, sortTime, bubbleTime, chooseTime);
        printArr(arr);
        printArr(alteredArr);
        return alteredArr;
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int search(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == (elem)) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int elem) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        int middleIndex;

        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elem) return middleIndex;
            else if (arr[middleIndex] < elem) firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > elem) lastIndex = middleIndex - 1;
        }
        return -1;
    }

    public static int[] createAndFillArr(int numberOfCopies) {
        Random r = new Random();
        int[] arr = new int[numberOfCopies];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(numberOfCopies);
        }
        return arr;
    }

    public static void swapElems(int[] arr, int firstIndex, int secondIndex) {
        int tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }
}
