package BST;

import java.util.ArrayList;
import java.util.List;

public class BST {

    public static class Node {
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

    public Node delete(Album data) {
        if (root == null) {
            throw new IllegalArgumentException("The BST is empty.");
        }

        return deleteRec(root, null, data);
    }

    private Node deleteRec(Node current, Node parent, Album data) {
        if (current == null) {
            throw new IllegalArgumentException("does not exist.");
        }

        int comparison = data.compareTo(current.data);

        if (comparison < 0) {
            current.left = deleteRec(current.left, current, data);
        } else if (comparison > 0) {
            current.right = deleteRec(current.right, current, data);
        } else {
            // Case 1: Node to be deleted is a leaf node
            if (current.left == null && current.right == null) {

                if (parent == null) {
                    root = null;
                } else {

                    if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            }
            // Case 2: Node to be deleted has only one child
            else if (current.left == null) {
                if (parent == null) {
                    root = current.right;
                } else {
                    if (parent.left == current) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) {
                if (parent == null) {
                    root = current.left;
                } else {
                    if (parent.left == current) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            }
            // Case 3: Node to be deleted has two children
            else {
                Node successor = findMin(current.right);
                current.data = successor.data;
                current.right = deleteRec(current.right, current, successor.data);
            }
        }
        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
