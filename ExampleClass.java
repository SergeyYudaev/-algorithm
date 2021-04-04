import java.util.Objects;

public class ExampleClass implements Comparable<ExampleClass> {

    private String name;
    private int value;
    static int i = 0;

    public ExampleClass(int value) {
        this.name = String.format("Экземпляр %s", i);
        this.value = value;
        i++;
    }

    @Override
    public String toString() {
        return String.format("%s, ",value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleClass that = (ExampleClass) o;
        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public int compareTo(ExampleClass o) {
        return value - o.value;
    }
}