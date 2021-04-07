import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private final Vertex[] vertices;
    private final int[][] adjMatrix;
    private int graphSize;
    Stack<Integer> stack;

    public Graph(int size) {
        vertices = new Vertex[size];
        adjMatrix = new int[size][size];
        graphSize = 0;
        stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char... Labels) {
        for (char label : Labels) {
            vertices[graphSize++] = new Vertex(label);
        }
    }

    public void addEdge(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            adjMatrix[arr[0][i]][arr[1][i]] = 1;
            adjMatrix[arr[1][i]][arr[0][i]] = 1;
        }
    }

    public void addEdge(int start, int end) {
        if (start < graphSize && end < graphSize) {
            adjMatrix[start][end] = 1;
            adjMatrix[end][start] = 1;
        }
    }

    public void printAdjMatrix() {
        System.out.print("n ");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.printf("%s ", i);
        }
        System.out.println();
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.printf("%s ", i);
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.printf("%s ", adjMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private void resetFlags() {
        for (int i = 0; i < graphSize; i++) {
            vertices[i].setWasVisited(false);
        }
    }

    private void displayVertex(int vertexPos) {
        System.out.printf("%s ", (vertices[vertexPos]).getLabel());
    }

    private int getAdjUnvisitedVertex(int vertexPos) {
        for (int i = vertexPos; i < graphSize; i++) {
            if (adjMatrix[vertexPos][i] == 1 && vertices[i].wasNotVisited()) return i;
        }
        return -1;
    }

    public void depthFirstTraversal(int vertexPos) {
        if (vertexPos <= graphSize) {
            vertices[vertexPos].setWasVisited(true);
            displayVertex(vertexPos);
            stack.push(vertexPos);
            while (!stack.isEmpty()) {
                int nextVertex = getAdjUnvisitedVertex(stack.peek());
                if (nextVertex == -1) stack.pop();
                else {
                    vertices[nextVertex].setWasVisited(true);
                    displayVertex(nextVertex);
                    stack.push(nextVertex);
                }
            }
            System.out.println();
            resetFlags();
        } else {
            System.out.println("Слишком большой индекс");
        }
    }

    public void breadthFirstTraversal(int vertexPos) {
        Queue<Integer> queue = new LinkedList<>();
        vertices[vertexPos].setWasVisited(true);
        displayVertex(vertexPos);
        queue.add(vertexPos);

        int nextVertex;
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            while ((nextVertex = getAdjUnvisitedVertex(currentVertex)) != -1) {
                vertices[nextVertex].setWasVisited(true);
                displayVertex(nextVertex);
                queue.add(nextVertex);
            }
        }
        resetFlags();
        System.out.println();
    }

    public int depthFirstSearch(int elem) {
        vertices[0].setWasVisited(true);
        stack.push(0);
        while (!stack.isEmpty()) {
            int nextVertex = getAdjUnvisitedVertex(stack.peek());
            if (nextVertex != -1 && vertices[nextVertex].getLabel() == elem) {
                resetFlags();
                return nextVertex;
            }
            if (nextVertex == -1) stack.pop();
            else {
                vertices[nextVertex].setWasVisited(true);
                stack.push(nextVertex);
            }
        }
        System.out.println();
        resetFlags();
        return -1;
    }

    public int getGraphSize() {
        return graphSize;
    }

}

class Vertex {
    private final char label;
    private boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}';
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public char getLabel() {
        return label;
    }

    public boolean wasNotVisited() {
        return !wasVisited;
    }
}