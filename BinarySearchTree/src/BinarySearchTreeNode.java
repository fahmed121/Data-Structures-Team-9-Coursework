package BinarySearchTree.src;// Binary Search Tree Node


public class BinarySearchTreeNode {

    String postcode;
    BinarySearchTreeNode left, right;

    public BinarySearchTreeNode(String postcode) {
        this.postcode = postcode;
        this.left = this.right = null;
    }
}