import java.util.*;

public class Main {
    public static void main(String[] args) {
        int elemCount = 10;

        TaskList taskList = new TaskList();
        ExampleClass[] arr = Utills.createAndFillEClassArr(elemCount);

        /**Задание 4.1
         * На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
         * Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        MyArrayStack<ExampleClass> arrayStackEClass = new MyArrayStack<>(elemCount);
        taskList.task1(arrayStackEClass, arr);

        /**Задание 4.2
         * На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
         * Реализуйте вспомогательные методы.
         * Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        MyArrayQueue<ExampleClass> arrayQueueEClass = new MyArrayQueue<>(elemCount);
        taskList.task2(arrayQueueEClass, arr);

        /**Задание 4.3
         * На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
         * Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        Deque<ExampleClass> arrayDuque = new ArrayDeque<>();
        taskList.task3(arrayDuque, arr);

        /**Задание 4.4
         * Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
         * Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        taskList.task4(priorityQueue, arr);

        /**Задание 4.5
         * На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
         * Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        LinkedList<ExampleClass> linkedQueue = new LinkedList();//потому что LinkedList это и есть очередь/стек на основе связанного списка
        LinkedList<ExampleClass> linkedStack = new LinkedList();
        taskList.task5(linkedQueue, linkedStack, arr);


    }
}
