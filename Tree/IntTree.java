package Tree;

public class IntTree {
    public IntNode root;

    public IntNode find(int value) {
        if (root == null) return null;
        IntNode current = root;

        while (!(current.value == value)) {
            if (value < current.value) current = current.leftChild;
            else current = current.rightChild;
        }
        return current;
    }

    public void insert(int... values) {
        for (int value : values) {
            IntNode intNode = new IntNode();
            intNode.value = value;

            if (root == null) root = intNode;
            else {
                IntNode current = root;
                IntNode parent;

                while (true) {
                    parent = current;
                    if (value < current.value) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = intNode;
                            break;
                        }
                    } else if (value > current.value) {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = intNode;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void preOrder(IntNode intNode) {
        if (intNode != null) {
            System.out.printf("%s ", intNode.toString());
            preOrder(intNode.leftChild);
            preOrder(intNode.rightChild);
        }
    }

    public void postOrder(IntNode intNode) {
        if (intNode != null) {
            postOrder(intNode.leftChild);
            postOrder(intNode.rightChild);
            System.out.printf("%s ", intNode.toString());
        }
    }

    public void inOrder(IntNode intNode) {
        if (intNode != null) {
            inOrder(intNode.leftChild);
            System.out.printf("%s ", intNode.toString());
            inOrder(intNode.rightChild);
        }
    }

    public void display() {
        System.out.print("Префиксный порядок: ");
        preOrder(root);
        System.out.print("\nПостфиксный порядок: ");
        postOrder(root);
        System.out.print("\nИнфиксный порядок: ");
        inOrder(root);
        System.out.println();
    }

    public IntNode min() {
        IntNode current = root;
        IntNode parent = null;

        while (current != null) {
            parent = current;
            current = current.leftChild;
        }
        return parent;
    }

    public IntNode max() {
        IntNode current = root;
        IntNode parent = null;

        while (current != null) {
            parent = current;
            current = current.rightChild;
        }
        return parent;
    }

    public boolean delete(int value) {
        if (root == null) return false;
        IntNode current = root;
        IntNode parent = null;
        boolean isLeftChild = false;

        while (current.value != value) {
            parent = current;
            if (value < current.value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null) return false;
        }

        if (current.leftChild == null && current.rightChild == null) {//узел-лист
            if (current == root) root = null;
            else if (isLeftChild) parent.leftChild = null;
            else parent.rightChild = null;
        } else if (current.rightChild == null) {                   //у узла только левый потомок
            if (current == root) root = current.leftChild;
            if (isLeftChild) parent.leftChild = current.leftChild;
            else parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) {                    //у узла только правый потомок
            if (current == root) root = current.rightChild;
            if (isLeftChild) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        } else {                                                   //у узла два потомка
            IntNode successor = getSuccessor(current);
            if (current == root) root = successor;
            else if (isLeftChild) parent.leftChild = successor;
            else parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private IntNode getSuccessor(IntNode intNode) {
        IntNode successorParent = intNode;
        IntNode successor = intNode;
        IntNode current = intNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != intNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = intNode.rightChild;
        }
        return successor;
    }


}

