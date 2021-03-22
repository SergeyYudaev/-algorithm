import java.util.Stack;

public class MyArrayStack<T> {
    private final Object[] stack;
    private int top = -1;

    public MyArrayStack(int maxSize) {
        this.stack = new Object[maxSize];
    }

    public void push(T elem) {
        stack[++top] = elem;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) return null;
        return (T) stack[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (top == -1) return null;
        return (T) stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
