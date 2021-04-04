package Tree;

class IntNode {
    int value;
    IntNode rightChild;
    IntNode leftChild;

    @Override
    public String toString() {
        return String.format("{v: %s}", value);
//        return String.format("{v:%s, l:%s, r:%s}", value, leftChild, rightChild);
    }
}