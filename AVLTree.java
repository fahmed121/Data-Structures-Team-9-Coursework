
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Node {

    private Node Parent;
    private Node Left;
    private Node Right;
    private String Value;
    private int height;

    public Node(String Value) { //Used for root
        this.Value = Value;
        this.Left = null;
        this.Right = null;
        this.Parent = null;
        height = 1;
    }

    public Node(String Value, Node Parent) {
        this.Value = Value;
        this.Left = null;
        this.Right = null;
        this.Parent = Parent;
    }

    public String getValue() {
        return Value;
    }

    public Node getLeft() {
        return Left;
    }

    public Node getRight() {
        return Right;
    }

    public Node getParent() {
        return Parent;
    }

    public int getHeight(Node node){
        if (node == null){
            return 0;
        } else {
            return node.height;
        }
    }

    public int getHeight(){ //Delete after testing
        return height;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public void setLeft(Node Left) {
        this.Left = Left;
    }

    public void setRight(Node Right) {
        this.Right = Right;
    }

    public void setLeftRight(Node Left, Node Right) {
        this.Left = Left;
        this.Right = Right;
    }

    public void setParent(Node Parent) {
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

    public void updateHeight(){
        height = 1 + Math.max(getHeight(Left), getHeight(Right));
    }
    public int getBalance(){
        return getHeight(Left) - getHeight(Right);
    }


}

class AVLTree {

    private Node root = null;
    private int NodeAmt = 0;

    public int getCount() {
        return NodeAmt;
    }

    public void Insert(String newNode) {
        boolean sucess = false;
        Node target = root;

        while (true) {
            if (root == null) {
                Node in = new Node(newNode);
                root = in;
                NodeAmt++;
                
                break;
            } 

                if (compString(newNode, target.getValue()) < 0) {// if in node is less than root
                    if (target.getLeft() == null) {
                        Node in = new Node(newNode, target);
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
                        Node in = new Node(newNode, target);
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

    private Node balance(Node node) {
        int balance = node.getBalance();

        // Left-Left case
        if (balance > 1 && compString(node.getLeft().getValue(), node.getValue()) < 0) {
            return rightRotate(node);
        }

        // Right-Right case
        if (balance < -1 && compString(node.getRight().getValue(), node.getValue()) > 0) {
            return leftRotate(node);
        }

        // Left-Right case
        if (balance > 1 && compString(node.getLeft().getValue(), node.getValue()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right-Left case
        if (balance < -1 && compString(node.getRight().getValue(), node.getValue()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        if (T2 != null) T2.setParent(x);

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        if (T2 != null) T2.setParent(y);

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    public Boolean Delete(String inxVal) {
        inxVal = inxVal.toUpperCase();
        boolean success = false;
        Node target = root;
        Node parent = null;

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
            Node child = target.getLeft() != null ? target.getLeft() : target.getRight();
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
            Node successor = findMin(target.getRight());
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

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private Node deleteNode(Node node, String value) {
        if (node == null) return node;

        if (compString(value, node.getValue()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), value));
        } else if (compString(value, node.getValue()) > 0) {
            node.setRight(deleteNode(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setValue(findMin(node.getRight()).getValue());
            node.setRight(deleteNode(node.getRight(), node.getValue()));
        }

        node.updateHeight();
        return balance(node);
    }

    private Integer compString(String a, String b) {
        return a.compareTo(b);
    }

    public Boolean Search(String inxVal) {
        inxVal = inxVal.toUpperCase();
        boolean sucess = false;
        Node target = root;
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
        // Returns Nodes in alphabetical order
        public String[] InOrder() {
            List<String> result = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            Node current = root;
        
            while (current != null || !stack.isEmpty()) {
                // Go to the leftmost node
                while (current != null) {
                    stack.push(current);
                    current = current.getLeft();
                }
        
                // Visit the node
                current = stack.pop();
                result.add(current.getValue());
        
                // Visit the right subtree
                current = current.getRight();
            }
            Collections.sort(result, new CompareString());
            
            return result.toArray(new String[0]);
        }

        public String displayNodeR(Node a) {
            String R = "";
            R=R+"Value: " + a.getValue();
            if (a.getLeft() != null) {
                R=R+"\nLeft node: " + a.getLeft().getValue();
            }
            if (a.getRight() != null) {
                R=R+"\nRight node: " + a.getRight().getValue();
            }
    
            if (a.getParent() != null) {
                R=R+"\nParent node: " + a.getParent().getValue();
            }
    
            R=R+"\n";
            return R;
        }

    public void displayNode(Node a) {
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
    public void Output(String name) throws IOException{
        //This part retrieves the local date and uses it as the CSV name
        
        String Filename = name+".csv";
        FileWriter writer = new FileWriter(Filename);
        writer.append(Arrays.toString(InOrder()));
        writer.close();
        System.out.println("File Saved");
    }
    //Spits out Nodes w/ relations
    public void Output() throws IOException {
        String Filename = "name.csv";
        FileWriter writer = new FileWriter(Filename);
        
        
        
    List<String> result = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node current = root;

    while (current != null || !stack.isEmpty()) {
        // Go to the leftmost node
        while (current != null) {
            stack.push(current);
            current = current.getLeft();
        }

        // Visit the node
        current = stack.pop();
        
        writer.append(displayNodeR(current));

        // Visit the right subtree
        current = current.getRight();
    }
    Collections.sort(result, new CompareString());
    writer.close();
    System.out.println("File Saved");
    }
}
public class AVLTree {

    public static List<String> pCodes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AVLTree Tree = new AVLTree();
        Import();
        for (int i = 1; i < pCodes.size(); i++) {
            Tree.Insert(pCodes.get(i));
        }
        System.out.println(Tree.getCount());
        Tree.Search("W9 3DR");


    }

    private static void Import() {
        try {
            File obj = new File("16000_London_Postcodes.txt");
            Scanner Reader = new Scanner(obj);

            while (Reader.hasNextLine()) {
                pCodes.add(Reader.nextLine());
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }

}
