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
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            insertRec(root, newNode);
        }

        return newNode;
    }

    private void insertRec(Node current, Node newNode) {
        int compareResult = newNode.data.compareTo(current.data);

        if (compareResult < 0) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                insertRec(current.left, newNode);
            }
        } else if (compareResult > 0) {
            if (current.right == null) {
                current.right = newNode;
            } else {
                insertRec(current.right, newNode);
            }
        } else {

            if (current.left == null) {
                current.left = newNode;
            } else {
                insertRec(current.left, newNode);
            }
        }
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
    public boolean contains(Album data) {
        return containsRec(root, data);
    }

    private boolean containsRec(Node current, Album data) {
        if (current == null) {
            return false;
        }

        int comparison = data.compareTo(current.data);

        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return containsRec(current.left, data);
        } else {
            return containsRec(current.right, data);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb);
        return sb.toString();
    }

    private void toStringRec(Node current, StringBuilder sb) {
        if (current == null) {
            sb.append("N, ");
            return;
        }

        sb.append(current.data.getId()).append(", ");
        toStringRec(current.left, sb);
        toStringRec(current.right, sb);

        if (current.left == null) {
            sb.append("N, ");
        }

        if (current.right == null) {
            sb.append("N, ");
        }
    }



}
