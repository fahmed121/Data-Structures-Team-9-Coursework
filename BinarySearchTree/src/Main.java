package BinarySearchTree.src;//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Locale;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        BinarySearchTree tree = new BinarySearchTree();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the path to the postcode text file: ");
//        String filePath = scanner.nextLine();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                tree.insert(line.trim());
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//            return;
//        }
//
//        System.out.print("Use BST or AVL? (Enter 'bst' or 'avl'): ");
//        String choice = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
//
//        if(choice.equals("BST")) {
//
//            /**************************************BST*********************************************/
//            //After loading from file
//            //inorder
//            //count
//            System.out.println("\nPostcodes loaded into BST in ascending alphabetical order:");
//            tree.inOrder();
//            System.out.println("Total postcodes (count): " + tree.count());
//
//            //Search
//            System.out.print("\nEnter a postcode to search: ");
//            String searchCode = scanner.nextLine();
//            System.out.println("Search result: " + (tree.search(searchCode) ? "Found" : "Not Found"));
//
//            //Insert
//            System.out.print("\nEnter a postcode to insert: ");
//            String insertCode = scanner.nextLine();
//            tree.insert(insertCode);
//            System.out.println("After insertion:");
//            tree.inOrder();
//            System.out.println("Total postcodes (count): " + tree.count());
//
//            //Delete
//            System.out.print("\nEnter a postcode to delete: ");
//            String deleteCode = scanner.nextLine();
//            boolean deleted = tree.delete(deleteCode);
//            System.out.println("Delete " + deleteCode + ": " + (deleted ? "Successful" : "Not Found"));
//            System.out.println("After deletion:");
//            tree.inOrder();
//            System.out.println("Total postcodes (count): " + tree.count());
//
//            //Display sorted postcodes as array
//            System.out.println("\nPostcodes in ascending order (from inOrder method):");
//            String[] sortedPostcodes = tree.inOrder();
//            for (String postcode : sortedPostcodes) {
//                System.out.println(postcode);
//            }
//        } else if (choice.equals("AVL")){
//            System.out.println("\nPostcodes loaded into AVL Tree (in-order):");
//            for (String postcode : tree.inOrder()) {
//                System.out.println(postcode);
//            }
//            System.out.println("Total postcodes (count): " + tree.count());
//
//            // Search
//            System.out.print("\nEnter a postcode to search: ");
//            String searchCode = scanner.nextLine();
//            System.out.println("Search result: " + (tree.search(searchCode) ? "Found" : "Not Found"));
//
//            // Insert
//            System.out.print("\nEnter a postcode to insert: ");
//            String insertCode = scanner.nextLine();
//            tree.insert(insertCode);
//            System.out.println("After insertion:");
//            for (String postcode : tree.inOrder()) {
//                System.out.println(postcode);
//            }
//
//            // Delete
//            System.out.print("\nEnter a postcode to delete: ");
//            String deleteCode = scanner.nextLine();
//            boolean deleted = tree.delete(deleteCode);
//            System.out.println(deleted ? "Postcode deleted." : "Postcode not found.");
//            System.out.println("After deletion:");
//            for (String postcode : tree.inOrder()) {
//                System.out.println(postcode);
//            }
//        }
//
//        scanner.close();
//    }
//}
