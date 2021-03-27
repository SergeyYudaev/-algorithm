import java.util.Random;

public class Utills {

    public static long time(Runnable runnable) {
        long t = System.nanoTime();
        runnable.run();
        return System.nanoTime() - t;
    }

    public static int[] generateAndFillIntArr(int size){
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(size);
        }
        return arr;
    }
}
