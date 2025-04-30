package BinarySearchTree.src;//import java.util.ArrayList;
//import java.util.List;
//
//class Node {
//
//    private Node Parent;
//    private Node Left;
//    private Node Right;
//    private String Value;
//
//    public Node(String Value) { //Used for root
//        this.Value = Value;
//        this.Left = null;
//        this.Right = null;
//        this.Parent = null;
//    }
//
//    public Node(String Value, Node Parent) {
//        this.Value = Value;
//        this.Left = null;
//        this.Right = null;
//        this.Parent = Parent;
//    }
//
//    public String getValue() {
//        return Value;
//    }
//
//    public Node getLeft() {
//        return Left;
//    }
//
//    public Node getRight() {
//        return Right;
//    }
//
//    public Node getParent() {
//        return Parent;
//    }
//
//    public void setValue(String Value) {
//        this.Value = Value;
//    }
//
//    public void setLeft(Node Left) {
//        this.Left = Left;
//    }
//
//    public void setRight(Node Right) {
//        this.Right = Right;
//    }
//
//    public void setLeftRight(Node Left, Node Right) {
//        this.Left = Left;
//        this.Right = Right;
//    }
//
//    public void setParent(Node Parent) {
//        this.Parent = Parent;
//    }
//
//    public int hasChildren() {
//        int i = 0;
//        if (getLeft() != null) {
//            i++;
//        }
//        if (getRight() != null) {
//            i++;
//        }
//        return i;
//
//    }
//
//}
//
//public class BinaryTree {
//
//    private Node root = null;
//    private int NodeAmt = 0;
//
//    // Returns Amount of nodes
//    public int getCount() {
//        return NodeAmt;
//    }
//
//    // Inserts new node
//    public void Insert(String newNode) {
//        boolean sucess = false;
//        Node target = root;
//
//        while (!sucess) {
//            if (root == null) {
//                Node in = new Node(newNode);
//                root = in;
//                NodeAmt++;
//                sucess = true;
//            } else {
//
//                if (compString(newNode, target.getValue()) < 0) {// if in node is less than root
//                    if (target.getLeft() == null) {
//                        Node in = new Node(newNode, target);
//                        target.setLeft(in);
//                        sucess = true;
//                        NodeAmt++;
//                    } else {
//                        target = target.getLeft();
//                    }
//                } else {
//                    if (target.getRight() == null) {
//                        Node in = new Node(newNode, target);
//                        target.setRight(in);
//                        sucess = true;
//                        NodeAmt++;
//
//                    } else {
//                        target = target.getRight();
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    public Boolean Delete(String inxVal) {
//        inxVal = inxVal.toUpperCase();
//        boolean sucess = false;
//        Node target = root;
//        Node parent = null;
//        while (true) {
//            if (compString(inxVal, target.getValue()) < 0) {// if in node is less than root
//                parent = target;
//                target = target.getLeft();
//            } else if (compString(inxVal, target.getValue()) > 0) {
//                parent = target;
//                target = target.getRight();
//
//            } else {
//                System.out.println("Node found!");
//                displayNode(target);
//                sucess = true;
//                break;
//            }
//
//        }
//        if (!sucess) {
//            System.out.println("Item not found");
//            return false;
//        }
//        //Replacemnet node
//
//        switch (target.hasChildren()) {
//            case 1, 0:
//                Node child = target.getLeft();
//                if (target.getLeft() == null) {
//                    child = target.getRight();
//                }
//
//                if (parent == null) {
//                    root = child; // Deleting root
//                } else if (parent.getLeft() == target) {
//                    parent.setLeft(child);
//                } else {
//                    parent.setRight(child);
//                }
//
//                if (child != null) {
//                    child.setParent(parent);
//                }
//                break;
//            case 2:
//                Node successorParent = target;
//                Node successor = target.getRight();
//
//                while (successor.getLeft() != null) {
//                    successorParent = successor;
//                    successor = successor.getLeft();
//                }
//
//                target.setValue(successor.getValue()); // Copy successor's value
//
//                // Delete successor
//                if (successorParent.getLeft() == successor) {
//                    successorParent.setLeft(successor.getRight());
//                } else {
//                    successorParent.setRight(successor.getRight());
//                }
//
//                if (successor.getRight() != null) {
//                    successor.getRight().setParent(successorParent);
//                }
//                break;
//        }
//
//        NodeAmt--;
//        return sucess;
//    }
//    // Search function
//
//    public Boolean Search(String inxVal) {
//        inxVal = inxVal.toUpperCase();
//        boolean sucess = false;
//        Node target = root;
//        while (!sucess) {
//            if (target == null) {
//                System.out.println("Item not found");
//                break;
//            } else {
//                if (compString(inxVal, target.getValue()) < 0) {// if in node is less than root
//                    target = target.getLeft();
//                } else if (compString(inxVal, target.getValue()) > 0) {
//                    target = target.getRight();
//
//                } else {
//                    System.out.println("Node found!");
//                    displayNode(target);
//                    sucess = true;
//
//                }
//
//            }
//        }
//
//        return sucess;
//    }
//
//    // Returns Nodes in alphabetical order
//    public String[] InOrder() {
//        Node target = root;
//        Node hold;
//        boolean sucess = false;
//        int i = 0;
//        int level = 1;
//        List<Node> OrderedCodes = new ArrayList<>();
//        OrderedCodes.add(target);
//        while (i < NodeAmt) {
//            target.getLeft();
//
//        }
//        String[] ReturnArray = new String[NodeAmt];
//
//        return ReturnArray;
//    }
////
////    public String[] InOrderC() {
////        List<String> pCodes = Btree.pCodes;
////        Collections.sort(pCodes, new CompareString());
////        String[] ReturnArray = new String[pCodes.size()];
////        for (int i = 0; i < pCodes.size(); i++) {
////            ReturnArray[i] = pCodes.get(i);
////        }
////        return ReturnArray;
////    }
//
//    // for testing
//    public void displayNode(Node a) {
//        System.out.println("Value: " + a.getValue());
//        if (a.getLeft() != null) {
//            System.out.println("Left node: " + a.getLeft().getValue());
//        }
//        if (a.getRight() != null) {
//            System.out.println("Right node: " + a.getRight().getValue());
//        }
//
//        if (a.getParent() != null) {
//            System.out.println("Parent node: " + a.getParent().getValue());
//        }
//
//        System.out.println();
//    }
//
//    private Integer compString(String a, String b) {
//        return a.compareTo(b);
//    }
//
//}
