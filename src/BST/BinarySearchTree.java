package BST;

import javax.swing.tree.TreeNode;

public class BinarySearchTree <T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node<T> insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        } else {
            return insert(root, data);
        }
    }

    private Node<T> insert(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        int compareResult = data.compareTo(current.data);
        if (compareResult < 0) {
            current.left = insert(current.left, data);
        } else if (compareResult > 0) {
            current.right = insert(current.right, data);
        }

        return current;
    }

    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}