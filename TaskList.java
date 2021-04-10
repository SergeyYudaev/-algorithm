public class TaskList {
    void task1() {
        System.out.println("Task1");
        System.out.println("Хэш-таблицы используются для защищенного хранения и передачи данных, таких, как личные " +
                "данные и служебная информация");
    }

    void task2() {
        System.out.println("\nTask2");
        System.out.println("Ключ - входные данные для хэширования. Коллизия - ситуация, при которой двум и более значениям" +
                "соответствует одинаковый хэш-код");
    }

    void task3() {
        System.out.println("\nTask3");
        System.out.println("Эффективной функцией хэширования можно считать .hashcode() метод класса Object");
    }

    LinearProbingHashTable task4(ExampleClass[] arr) {
        System.out.println("\nTask4");
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable((int) (arr.length * 1.5));
        for (int i = 0; i < arr.length; i++) {
            linearProbingHashTable.insert(arr[i]);
        }
        return linearProbingHashTable;
    }

    DoubleHashingHashTable task5(ExampleClass[] arr) {
        System.out.println("\nTask5");
        DoubleHashingHashTable doubleHashingHashTable = new DoubleHashingHashTable((int) (arr.length * 1.5));
        for (int i = 0; i < arr.length; i++) {
            doubleHashingHashTable.insert(arr[i]);
        }
        return doubleHashingHashTable;
    }
}
