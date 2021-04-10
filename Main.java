import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        //Задание 8.1
        //Приведите пример использование хеш-таблиц.
        taskList.task1();

        //Задание 8.2
        //Приведите примеры ключей и коллизий.
        taskList.task2();

        //Задание 8.3
        //Приведите примеры популярных и эффективных хеш-функций.
        taskList.task3();

        //Задание 8.4
        //На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
        ExampleClass[] arr = createAndFillArr(20);
        LinearProbingHashTable linearProbingHashTable = taskList.task4(arr);
        linearProbingHashTable.display();

        //Задание 8.5
        //Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
        //Сравните отличительные черты двух алгоритмов.

        DoubleHashingHashTable doubleHashingHashTable = taskList.task5(arr);
        doubleHashingHashTable.display();

    }

    public static ExampleClass[] createAndFillArr(int count) {
        ExampleClass[] exampleClasses = new ExampleClass[count];
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            exampleClasses[i] = new ExampleClass(r.nextInt(count*2));
        }
        return exampleClasses;
    }

}
