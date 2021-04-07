
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        TaskList taskList = new TaskList();
//        Задание 7.1
//        Приведите пример графа.
        taskList.task1();
//        Задание 7.2
//        Реализуйте базовые методы графа.
        taskList.task2(graph);
//        В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
//        Выполните оценку времени с помощью System.nanoTime().
        taskList.task3(graph);
//        В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
//                Выполните оценку времени с помощью System.nanoTime().
        taskList.task4(graph);
    }
}