package BinarySearchTree.src;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private BinarySearchTreeNode root;
    private int count = 0;

    public BinarySearchTree() {
        this.root = null;
    }

    public int count() {
        return count;
    }

    public void insert(String postcode) {
        if (!search(postcode)) {
            root = insertRec(root, postcode);
            count++;
        }
    }

    private BinarySearchTreeNode insertRec(BinarySearchTreeNode node, String postcode) {
        if (node == null) return new BinarySearchTreeNode(postcode);

        if (postcode.compareTo(node.postcode) < 0) {
            node.left = insertRec(node.left, postcode);
        } else if (postcode.compareTo(node.postcode) > 0) {
            node.right = insertRec(node.right, postcode);
        }
        return node;
    }

    public boolean search(String postcode) {
        return searchRec(root, postcode);
    }

    private boolean searchRec(BinarySearchTreeNode node, String postcode) {
        if (node == null) return false;
        if (postcode.equals(node.postcode)) return true;
        return postcode.compareTo(node.postcode) < 0
                ? searchRec(node.left, postcode)
                : searchRec(node.right, postcode);
    }

    public boolean delete(String postcode) {
        if (!search(postcode)) return false;
        root = deleteRec(root, postcode);
        count--;
        return true;
    }

    private BinarySearchTreeNode deleteRec(BinarySearchTreeNode node, String postcode) {
        if (node == null) return null;

        if (postcode.compareTo(node.postcode) < 0) {
            node.left = deleteRec(node.left, postcode);
        } else if (postcode.compareTo(node.postcode) > 0) {
            node.right = deleteRec(node.right, postcode);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            node.postcode = minValue(node.right);
            node.right = deleteRec(node.right, node.postcode);
        }

        return node;
    }

    private String minValue(BinarySearchTreeNode node) {
        while (node.left != null)
            node = node.left;
        return node.postcode;
    }

    public String[] inOrder() {
        List<String> list = new ArrayList<>();
        inOrderToList(root, list);
        for (String postcode : list) {
            System.out.println(postcode);
        }
        return list.toArray(new String[0]);
    }

    private void inOrderToList(BinarySearchTreeNode node, List<String> list) {
        if (node != null) {
            inOrderToList(node.left, list);
            list.add(node.postcode);
            inOrderToList(node.right, list);
        }
    }

    public void displayTreeStructure() {
        printTree(root, "", true);
    }

    private void printTree(BinarySearchTreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.postcode);
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + "└── [null]");
            }

            if (node.right != null) {
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + "└── [null]");
            }
        }
    }
}
