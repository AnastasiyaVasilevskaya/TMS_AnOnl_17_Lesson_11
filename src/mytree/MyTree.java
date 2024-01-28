package mytree;

//Реализовать Свое дерево (с добавлением, удалением, проверкой на наличие и джинериком)

public class MyTree<T extends Comparable<T>> {
    private class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + left +
                    ", rightChild=" + right +
                    '}';
        }
    }

    private Node rootNode;

    public MyTree() {
        rootNode = null;
    }

    public void add(T value) {
        rootNode = addElement(rootNode, value);
    }

    private Node addElement(Node currentNode, T value) {
        Node newNode = new Node(value); //создание нового узла
        newNode.setValue(value); //вставка данных

        if (rootNode == null) {
            rootNode = newNode;

        } else {    //корневой узел занят, то
            Node parentNode = rootNode;
            while (true) {

                if (value == currentNode.getValue()) { //если равен
                    return currentNode;

                } else if (value.compareTo(currentNode.getValue()) < 0) { //влево
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) { //дошли до конца цепочки
                        parentNode.setLeft(newNode); //вставка слева, устанавливаем родителя и выход
                        return newNode;
                    }
                } else { //или направо
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return newNode;
                    }
                }
            }
        }
        return null;
    }


}
