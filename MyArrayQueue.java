public class MyArrayQueue<T> {
    private final int maxSize;
    private final Object[] queue;
    private int front;
    private int rear = -1;
    private int size;

    public MyArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new Object[maxSize];
    }

    public void insert(T elem) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = elem;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T remove() {
        T elem = (T) queue[front++];
        if (front == maxSize) {
            front = 0;
        }
        size--;
        return elem;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
