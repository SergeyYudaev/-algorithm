import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int numberOfCopies = 10; //кол-во элементов в arrayList
        final int value = 3; //искомое значения для задания 4

        ArrayList<ExampleClass> arrayList = new ArrayList<>();

        for (int i = 0; i < numberOfCopies; i++) {
            arrayList.add(new ExampleClass((int) (Math.random() * numberOfCopies))); //заполняем arrayList
        }

        System.out.println(arrayList);

        System.out.println(String.format("Искомый экземпляр по значению %d: %s", value, searchByValue(arrayList, value)));
    }

    //поиск в коллекции экзамляра по значению поля value
    public static String searchByValue(ArrayList<ExampleClass> arrayList, int value) {
        long start = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++) {
            if (value == arrayList.get(i).getValue()) return arrayList.get(i).toString();
        }
        String time = String.valueOf(System.nanoTime() - start);
        System.out.println(String.format("Выполнение заняло времени: %s, nanos", time));
        return "Элемент не найден";
    }

}
