package BST;

import java.util.ArrayList;
import java.util.List;

public class BST {

    private static class Node {
        Album data;
        Node left;
        Node right;

        Node(Album data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BST() {
        this.root = null;
    }

    public Node insert(Album data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            return insertRec(root, data);
        }
    }

    private Node insertRec(Node current, Album data) {
        if (current == null) {
            return new Node(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertRec(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRec(current.right, data);
        }

        return current;
    }

    public List<Album> getInOrderTraversal() {
        List<Album> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node node, List<Album> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.data);
            inOrderTraversal(node.right, result);
        }
    }
}
