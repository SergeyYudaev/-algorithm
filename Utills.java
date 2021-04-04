import java.util.Random;

public class Utills {
    public static long time(Runnable runnable) {
        long t = System.nanoTime();
        runnable.run();
        return System.nanoTime() - t;
    }

    public static ExampleClass[] createAndFillExampleClassArr(int quantity) {
        ExampleClass[] arr = new ExampleClass[quantity];
        Random r = new Random();
        for (int i = 0; i < quantity; i++) {
            arr[i] = new ExampleClass(i);
        }
        return arr;
    }
}
