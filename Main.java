import java.util.*;

public class Main {
    static long t;

    public static void main(String[] args) {
        ArrayList<String> arrayList = task1();
        ArrayList<String> copyArraylist = new ArrayList<>(arrayList);
        ArrayList<String> copyArraylist1 = new ArrayList<>(arrayList);
        task2(copyArraylist);
        LinkedList<String> linkedList = task4(copyArraylist1);
        task5(linkedList);
    }

    public static ArrayList<String> task1() {
        System.out.println("//Task1");
        final int elemCount = 50;
        String[] arr = createAndFillStringArr(elemCount);

        ArrayList<String> arrayList = new ArrayList<>();

        t = System.nanoTime();
        arrayList.addAll(Arrays.asList(arr));
        t = System.nanoTime() - t;
        printTimeNanos();

        t = System.nanoTime();
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(arr));
        t = System.nanoTime() - t;
        printTimeNanos();

        return arrayList;
    }

    public static void task2(ArrayList<String> arrayList) {
        System.out.println("\n//Task2");
        int searchElem = arrayList.size() / 3 * 2;

        System.out.println("Arraylist");
        t = System.nanoTime();
        System.out.println(arrayList);
        arrayList.add("new String");
        t = System.nanoTime() - t;
        printTimeNanos();

        t = System.nanoTime();
        System.out.println(arrayList);
        arrayList.remove(3);
        t = System.nanoTime() - t;
        printTimeNanos();

        t = System.nanoTime();
        System.out.println(arrayList.get(searchElem));
        t = System.nanoTime() - t;
        printTimeNanos();
    }

    public static LinkedList<String> task4(ArrayList<String> arrayList) {
        System.out.println("\n//Task4");
        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        int searchElem = arrayList.size() / 3 * 2;

        System.out.println("LinkedList");
        t = System.nanoTime();
        System.out.println(arrayList);
        linkedList.add("new String");
        t = System.nanoTime() - t;
        printTimeNanos();

        t = System.nanoTime();
        System.out.println(arrayList);
        linkedList.remove(3);
        t = System.nanoTime() - t;
        printTimeNanos();

        t = System.nanoTime();
        System.out.println(linkedList.get(searchElem));
        t = System.nanoTime() - t;
        printTimeNanos();

        LinkedList<Object> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new ExampleClass(i));
        }
        System.out.println(list);
        return linkedList;
    }

    public static void task5(LinkedList<String> linkedList) {
        System.out.println("\n//Task5");

        Iterator<String> iter = linkedList.iterator();
        t = System.nanoTime();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
            iter.remove();
        }
        t = System.nanoTime() - t;
        System.out.println();
        printTimeNanos();
        System.out.println("\n" + linkedList);
    }

    public static String[] createAndFillStringArr(int elemCount) {
        String[] arr = new String[elemCount];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(i);
        }
        return arr;
    }

    public static void printTimeNanos() {
        System.out.printf("Времени затрачено: %s\n", t);
    }

    public static void printTimeMills() {
        System.out.printf("Времени затрачено: %s\n", t / 1000000);
    }
}