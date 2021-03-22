import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TaskList {

    void task1(MyArrayStack<ExampleClass> myArrayStack, ExampleClass[] arr) {
        System.out.printf("Push from ExampleClass[] to MyArrayStack: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                myArrayStack.push(arr[i]);
                System.out.println(arr[i]);
            }
        }));

        System.out.printf("Pop from MyArrayStack: %s, nanos\n", Utills.time(() -> {
            while (!myArrayStack.isEmpty()) {
                System.out.println(myArrayStack.pop());
            }
        }));
    }

    void task2(MyArrayQueue<ExampleClass> myArrayQueue, ExampleClass[] arr) {
        System.out.printf("Insert from ExampleClass[] to MyArrayQueue: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                myArrayQueue.insert(arr[i]);
                System.out.println(arr[i]);
            }
        }));

        System.out.printf("Remove from MyArrayQueue: %s, nanos\n", Utills.time(() -> {
            while (!myArrayQueue.isEmpty()) {
                System.out.println(myArrayQueue.remove());
            }
        }));

        System.out.println(myArrayQueue.isEmpty());
        System.out.println(myArrayQueue.isFull());
    }

    void task3(Deque<ExampleClass> deque, ExampleClass[] arr) {
        System.out.printf("Add from ExampleClass[] to Deque: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) deque.addFirst(arr[i]);
                else deque.addLast(arr[i]);
                System.out.println(arr[i]);
            }
        }));

        System.out.printf("Poll from Deque: %s, nanos\n", Utills.time(() -> {
            while (!deque.isEmpty()) System.out.println(deque.poll());
        }));
    }

    void task4(PriorityQueue<Integer> priorityQueue, ExampleClass[] arr) {
        System.out.printf("Add from ExampleClass[] values to PriorityQueue: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                priorityQueue.add(arr[i].getValue());
                System.out.println(arr[i]);
            }
        }));

        System.out.printf("Poll from Deque: %s, nanos\n", Utills.time(() -> {
            while (!priorityQueue.isEmpty()) {
                System.out.println(priorityQueue.poll());
            }
        }));
    }

    void task5(LinkedList<ExampleClass> linkedQueue, LinkedList<ExampleClass> linkedStack, ExampleClass[] arr) {
        System.out.printf("Add from ExampleClass[] values to LinkedQueue: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                linkedQueue.addFirst(arr[i]);
                System.out.println(arr[i]);
            }
        }));

        System.out.printf("Poll from LinkedQueue: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(linkedQueue.pollLast());
            }
        }));

        System.out.printf("Add from ExampleClass[] values to LinkedStack: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                linkedStack.addFirst(arr[i]);
                System.out.println(arr[i]);
            }
        }));

        System.out.printf("Poll from LinkedStack: %s, nanos\n", Utills.time(() -> {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(linkedStack.pollFirst());
            }
        }));
    }
}
