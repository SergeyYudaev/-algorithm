public class DoubleHashingHashTable extends LinearProbingHashTable {

    public DoubleHashingHashTable(int arrSize) {
        super(arrSize);
    }

    @Override
    public void insert(ExampleClass exampleClass) {
        int key = exampleClass.getValue();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && (hashArr[hashVal]).getValue() != -1) {
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = exampleClass;
    }

    @Override
    public ExampleClass delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if ((hashArr[hashVal]).getValue() == key) {
                ExampleClass temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    @Override
    public ExampleClass find(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if ((hashArr[hashVal]).getValue() == key) {
                return hashArr[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    private int hashFuncDouble(int key) {
        return 5 - key % 5;
    }
}
