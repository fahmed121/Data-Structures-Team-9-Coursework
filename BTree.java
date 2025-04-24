
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node {

    private Node Parent;
    private Node Left;
    private Node Right;
    private String Value;

    public Node(String Value) {
        this.Value = Value;
        this.Left = null;
        this.Right = null;
        this.Parent = null;
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
    public void setParent(Node Parent){
        this.Parent = Parent;
    }

}

class BinaryTree {

    private Node root = null;
    private int NodeAmt = 0;

    // Returns Amount of nodes
    public int getCount() {
        return NodeAmt;
    }

    // Inserts new node
    public void Insert(String newNode) {
        boolean sucess = false;
        Node target = root;
        while (!sucess) {
            if (root == null) {
                Node in = new Node(newNode);
                root = in;
                sucess = true;
            } else {

                if (compString(newNode, target.getValue()) < 0) {// if in node is less than root
                    if (target.getLeft() == null) {
                        Node in = new Node(newNode, target);
                        target.setLeft(in);
                        sucess = true;
                        NodeAmt++;
                    } else {
                        target = target.getLeft();
                    }
                } else if (compString(newNode, target.getValue()) > 0) {
                    if (target.getRight() == null) {
                        Node in = new Node(newNode, target);
                        target.setRight(in);
                        sucess = true;
                        NodeAmt++;

                    } else {
                        target = target.getRight();
                    }
                } else {
                    System.out.println("Error, value: " + newNode + " is the same\ntry again");
                    displayNode(target);
                    break;
                }

            }
        }

    }

    public Boolean Delete(String inxVal) {
        inxVal = inxVal.toUpperCase();
        boolean sucess = false;
        Node target = root;
        Node replacement, temp;
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
        if (sucess){ //Replacemnet node must 
            replacement = target.getLeft().getRight();
            while (compString(replacement.getValue(), replacement.getParent().getValue())<0) { //if the replacemnet is less than target's left node 
                replacement=replacement.getRight();
                if (replacement==null) {
                    replacement=target.getLeft();
                    break;
                    
                }
            }
            target=replacement;

        }

        return sucess;
    }
    // Search function

    public Boolean Serach(String inxVal) {
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
        Node target = root;
        Node hold;
        boolean sucess = false;
        int i =0;
        int level = 1;
        List<Node> OrderedCodes = new ArrayList<>();
        OrderedCodes.add(target);
        while (i < NodeAmt) {
            target.getLeft();

        }
        String[] ReturnArray = new String[NodeAmt];
        
        return ReturnArray;
    }

    public String[] InOrderC() {
        List <String> pCodes = BTree.pCodes;
        Collections.sort(pCodes, new CompareString());
        String[] ReturnArray = new String[pCodes.size()];
        for (int i = 0; i < pCodes.size(); i++) {
            ReturnArray[i]=pCodes.get(i);
        }
        return ReturnArray;
    }

    // for testing
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

    // public void displayNode(Node a) {
    //     Node p = a.getParent();
    //     System.out.println("Value: " + a.getValue());
    //     if (a.getParent() != null) {
    //         System.out.println("Parent node: " + p.getValue());
    //     }
    //     System.out.println();
    // }

    // A=new
    private Integer compString(String a, String b) {
        return a.compareTo(b);
    }

}

public class BTree {

    public static List<String> pCodes = new ArrayList<>();

    public static void main(String[] args) {
        boolean imported = false;

        Scanner s = new Scanner(System.in);
        BinaryTree test = new BinaryTree();
        for (int i = 0; i < pCodes.size(); i++) {
            test.Insert(pCodes.get(i));

        }
        //System.out.println(Arrays.toString(test.InOrderC()));
        System.out.println(test.getCount());
        while (true) {

            System.out.println("Input command:\t");
            String q;
            String cmd = s.next();
            switch (cmd.toLowerCase()) {
                case "import":
                    if (!imported) {
                        Import();
                        for (int i = 0; i < pCodes.size(); i++) {
                            test.Insert(pCodes.get(i));
                        }
                        imported = true;
                    } else {
                        System.out.println("Files already printed");
                    }
                    break;
                case "search":
                    System.out.println("Enter query:\t");
                    q = s.next();
                    test.Serach(q);
                    break;
                case "delete":
                    System.out.println("Enter query:\t");
                    q = s.next();
                    test.Delete(q);
                    break;
                case "order":
                    test.InOrderC();
                    break;
                default:
                    throw new AssertionError();
            }
        }

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
