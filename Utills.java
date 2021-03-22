
public class Utills {

    public static long time(Runnable runnable) {
        long t = System.nanoTime();
        runnable.run();
        return (System.nanoTime() - t);
    }

    public static String[] createAndFillStringArr(int elemCount) {
        String[] arr = new String[elemCount];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(i);
        }
        return arr;
    }

    public static ExampleClass[] createAndFillEClassArr(int elemCount){
        ExampleClass[] arr = new ExampleClass[elemCount];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ExampleClass(i);
        }
        return arr;
    }
}
