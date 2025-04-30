package BinarySearchTree.src;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

class AVLNode {

    private AVLNode Parent;
    private AVLNode Left;
    private AVLNode Right;
    private String Value;
    private int height;

    public AVLNode(String Value) { //Used for root
        this.Value = Value;
        this.Left = null;
        this.Right = null;
        this.Parent = null;
        height = 1;
    }

    public AVLNode(String Value, AVLNode Parent) {
        this.Value = Value;
        this.Left = null;
        this.Right = null;
        this.Parent = Parent;
    }

    public String getValue() {
        return Value;
    }

    public AVLNode getLeft() {
        return Left;
    }

    public AVLNode getRight() {
        return Right;
    }

    public AVLNode getParent() {
        return Parent;
    }

    public int getHeight(AVLNode AVLNode) {
        if (AVLNode == null) {
            return 0;
        } else {
            return AVLNode.height;
        }
    }

    public int getHeight() { //Delete after testing
        return height;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public void setLeft(AVLNode Left) {
        this.Left = Left;
    }

    public void setRight(AVLNode Right) {
        this.Right = Right;
    }

    public void setLeftRight(AVLNode Left, AVLNode Right) {
        this.Left = Left;
        this.Right = Right;
    }

    public void setParent(AVLNode Parent) {
        this.Parent = Parent;
    }

    public int hasChildren() {
        int i = 0;
        if (getLeft() != null) {
            i++;
        }
        if (getRight() != null) {
            i++;
        }
        return i;

    }

    public void updateHeight() {
        height = 1 + Math.max(getHeight(Left), getHeight(Right));
    }

    public int getBalance() {
        return getHeight(Left) - getHeight(Right);
    }

}

public class AVLTree {

    private AVLNode root = null;
    private int NodeAmt = 0;

    public int getCount() {
        return NodeAmt;
    }

    public void Insert(String newNode) {
        boolean sucess = false;
        AVLNode target = root;

        while (true) {
            if (root == null) {
                AVLNode in = new AVLNode(newNode);
                root = in;
                NodeAmt++;

                break;
            }

            if (compString(newNode, target.getValue()) < 0) {// if in node is less than root
                if (target.getLeft() == null) {
                    AVLNode in = new AVLNode(newNode, target);
                    target.setLeft(in);
                    sucess = true;
                    NodeAmt++;
                    in.updateHeight();
                    break;
                } else {
                    target = target.getLeft();
                }
            } else {
                if (target.getRight() == null) {
                    AVLNode in = new AVLNode(newNode, target);
                    target.setRight(in);
                    sucess = true;
                    NodeAmt++;
                    in.updateHeight();
                    break;

                } else {
                    target = target.getRight();
                }
            }

        }

    }

    private AVLNode balance(AVLNode AVLNode) {
        int balance = AVLNode.getBalance();

        // Left-Left case
        if (balance > 1 && compString(AVLNode.getLeft().getValue(), AVLNode.getValue()) < 0) {
            return rightRotate(AVLNode);
        }

        // Right-Right case
        if (balance < -1 && compString(AVLNode.getRight().getValue(), AVLNode.getValue()) > 0) {
            return leftRotate(AVLNode);
        }

        // Left-Right case
        if (balance > 1 && compString(AVLNode.getLeft().getValue(), AVLNode.getValue()) > 0) {
            AVLNode.setLeft(leftRotate(AVLNode.getLeft()));
            return rightRotate(AVLNode);
        }

        // Right-Left case
        if (balance < -1 && compString(AVLNode.getRight().getValue(), AVLNode.getValue()) < 0) {
            AVLNode.setRight(rightRotate(AVLNode.getRight()));
            return leftRotate(AVLNode);
        }

        return AVLNode;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        if (T2 != null) {
            T2.setParent(x);
        }

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        if (T2 != null) {
            T2.setParent(y);
        }

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    public Boolean Delete(String inxVal) {
        inxVal = inxVal.toUpperCase();
        boolean success = false;
        AVLNode target = root;
        AVLNode parent = null;

        while (target != null) {
            if (compString(inxVal, target.getValue()) < 0) {
                parent = target;
                target = target.getLeft();
            } else if (compString(inxVal, target.getValue()) > 0) {
                parent = target;
                target = target.getRight();
            } else {
                success = true;
                break;
            }
        }

        if (!success) {
            System.out.println("Item not found");
            return false;
        }

        // Perform deletion
        if (target.hasChildren() == 0) {
            if (parent == null) {
                root = null;
            } else if (parent.getLeft() == target) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (target.hasChildren() == 1) {
            AVLNode child = target.getLeft() != null ? target.getLeft() : target.getRight();
            if (parent == null) {
                root = child;
            } else if (parent.getLeft() == target) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }

            if (child != null) {
                child.setParent(parent);
            }
        } else {
            AVLNode successor = findMin(target.getRight());
            target.setValue(successor.getValue());
            target.setRight(deleteNode(target.getRight(), successor.getValue()));
        }

        NodeAmt--;
        if (parent != null) {
            parent.updateHeight();  // Update height of the parent after deletion
        }

        // Balance the tree after deletion
        return balance(target) != null;
    }

    private AVLNode findMin(AVLNode AVLNode) {
        while (AVLNode.getLeft() != null) {
            AVLNode = AVLNode.getLeft();
        }
        return AVLNode;
    }

    private AVLNode deleteNode(AVLNode AVLNode, String value) {
        if (AVLNode == null) {
            return AVLNode;
        }

        if (compString(value, AVLNode.getValue()) < 0) {
            AVLNode.setLeft(deleteNode(AVLNode.getLeft(), value));
        } else if (compString(value, AVLNode.getValue()) > 0) {
            AVLNode.setRight(deleteNode(AVLNode.getRight(), value));
        } else {
            if (AVLNode.getLeft() == null) {
                return AVLNode.getRight();
            } else if (AVLNode.getRight() == null) {
                return AVLNode.getLeft();
            }

            AVLNode.setValue(findMin(AVLNode.getRight()).getValue());
            AVLNode.setRight(deleteNode(AVLNode.getRight(), AVLNode.getValue()));
        }

        AVLNode.updateHeight();
        return balance(AVLNode);
    }

    private Integer compString(String a, String b) {
        return a.compareTo(b);
    }

    public Boolean Search(String inxVal) {
        inxVal = inxVal.toUpperCase();
        boolean sucess = false;
        AVLNode target = root;
        while (!sucess) {
            if (target == null) {
                System.out.println("Item not found");
                break;
            } else {
                if (compString(inxVal, target.getValue()) < 0) {// if in node is less than root
                    target = target.getLeft();
                } else if (compString(inxVal, target.getValue()) > 0) {
                    target = target.getRight();

                } else {
                    System.out.println("Node found!");
                    displayNode(target);
                    sucess = true;

                }

            }
        }

        return sucess;
    }

    public void displayNode(AVLNode a) {
        System.out.println("Value: " + a.getValue());
        if (a.getLeft() != null) {
            System.out.println("Left node: " + a.getLeft().getValue());
        }
        if (a.getRight() != null) {
            System.out.println("Right node: " + a.getRight().getValue());
        }

        if (a.getParent() != null) {
            System.out.println("Parent node: " + a.getParent().getValue());
        }

        System.out.println();
    }
}
