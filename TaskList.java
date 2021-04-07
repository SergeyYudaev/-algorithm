import java.util.concurrent.atomic.AtomicInteger;

public class TaskList {
    public void task1() {
        System.out.println("Task1");
        System.out.println("Учитывая манеру подачи материала лектором, можно сказать, что примеры графа мы видем на " +
                "слайде и хорошо, что мы это видим, а теперь подведем итоги: мы рассмотрели примеры графов в жизни и " +
                "программировании");
    }

    public void task2(Graph graph) {
        System.out.println("Task2");
        graph.addVertex('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
        int[][] edgeArr = {{0, 0, 1, 1, 2, 3}, {1, 2, 3, 4, 5, 6}};
        graph.addEdge(edgeArr);
        graph.printAdjMatrix();
    }

    public void task3(Graph graph) {
        System.out.println("Task3");
        int vertexPos = 0;
        char elemToSearch = 'f';

        System.out.printf("Времени затрачено на обход графа из %s узлов с узла %s в глубину: %s, нс\n",
                graph.getGraphSize(), vertexPos, time(() -> graph.depthFirstTraversal(vertexPos)));

        AtomicInteger position = new AtomicInteger();
        System.out.printf("Времени затрачено на поиск элемента %s: %s, нс. номер элемента: %s\n",
                elemToSearch, time(() -> position.set(graph.depthFirstSearch(elemToSearch))), position);
    }

    public void task4(Graph graph) {
        System.out.println("Task4");
        int vertexPos = 0;
        System.out.printf("Времени затрачено на обход графа из %s узлов с узла %s в ширину: %s, нс\n",
                graph.getGraphSize(), vertexPos, time(() -> graph.breadthFirstTraversal(vertexPos)));

    }

    public static long time(Runnable runnable) {
        long t = System.nanoTime();
        runnable.run();
        return System.nanoTime() - t;
    }
}
