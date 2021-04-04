import Heap.Heap;
import Tree.IntTree;

import java.util.Arrays;
import java.util.TreeSet;

public class TaskList {

    void task1() {
        System.out.println("Task 1");
        System.out.println("Примером использования древовидной структуры можно считать TreeMap и TreeSet из java.Utill");
    }

    IntTree task2() {
        System.out.println("\nTask 2");
        IntTree intTree = new IntTree();
        return intTree;
    }

    void task3(IntTree intTree) {
        System.out.println("\nTask 3");
        intTree.insert(12, 8, 17, 6, 10, 15, 21, 9, 11, 5, 7, 14, 16);
        System.out.println(intTree.find(12));
    }

    void task4(IntTree intTree) {
        System.out.println("\nTask 4");
        intTree.display();
        System.out.println(intTree.min());
        System.out.println(intTree.max());
    }

    void task5(IntTree intTree) {
        System.out.println("\nTask 5");
        int elemToDelete = 8;
        intTree.display();
        System.out.printf("Времени на удаление элемента %s затрачено: %s,nanos\n", elemToDelete, Utills.time(() -> {
            System.out.printf("\nУдаление элемента %s прошло: %s\n\n", elemToDelete, intTree.delete(elemToDelete));
        }));
        intTree.display();
    }

    void task6(ExampleClass[] arr) {
        System.out.println("\nTask 6");
        ExampleClass[] arrCopy = Arrays.copyOf(arr, arr.length);
        ExampleClass[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        Heap<ExampleClass> heap = new Heap<ExampleClass>();
        System.out.printf("Времени на пирамидальную сортировку массива из %s элементов затрачено: %s,nanos\n", arrCopy.length, Utills.time(() -> {
            heap.sort(arrCopy);
        }));
        System.out.println(Arrays.toString(arrCopy));
        System.out.printf("Времени на быструю сортировку массива из %s элементов затрачено: %s,nanos\n", arrCopy.length, Utills.time(() -> {
            Arrays.sort(arrCopy1);
        }));
        System.out.println(Arrays.toString(arrCopy1));


    }

    void task7(ExampleClass[] arr) {
        System.out.println("\nTask 7");
        TreeSet<ExampleClass> treeSet = new TreeSet<>();
        System.out.printf("Времени на построение дерева TreeSet затрачено: %s,nanos\n", Utills.time(() -> {
            treeSet.addAll(Arrays.asList(arr));
        }));
        System.out.println(Arrays.toString(arr));
    }
}
