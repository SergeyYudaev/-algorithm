public class LinearProbingHashTable {
    protected final ExampleClass[] hashArr;
    protected final int arrSize;
    protected final ExampleClass nonItem;

    public LinearProbingHashTable(int arrSize) {
        this.arrSize = arrSize;
        this.hashArr = new ExampleClass[arrSize];
        nonItem = new ExampleClass(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.printf("%s;\n", (hashArr[i]).getValue());
            } else {
                System.out.print("***;\n");
            }
        }
    }

    public void insert(ExampleClass exampleClass) {
        int key = exampleClass.getValue();
        int hashVal = hashFunc(key);

        while (hashArr[hashVal] != null && (hashArr[hashVal]).getValue() != -1) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = exampleClass;
    }


    public ExampleClass delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if ((hashArr[hashVal]).getValue() == key) {
                ExampleClass temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }


    public ExampleClass find(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if ((hashArr[hashVal]).getValue() == key) {
                return hashArr[hashVal];
            }
            hashVal++;
            hashVal %= arrSize;
        }
        return null;
    }

    protected int hashFunc(int key) {
        return key % arrSize;
    }
}
