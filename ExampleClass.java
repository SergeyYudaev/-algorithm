public class ExampleClass {
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
        return "ExampleClass{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }
}
