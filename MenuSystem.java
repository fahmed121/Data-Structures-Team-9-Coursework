/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures.group3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuSystem {
    
    private ArrayList postcode;
    
    public MenuSystem(){
      ArrayList<String> postcode = new ArrayList<>();
    }
    
    public  ArrayList<String> ChooseFile() throws FileNotFoundException{
        Scanner s = new Scanner(System.in);
        
        System.out.println("What File would you like to use?");
        System.out.println("1. 1000 Postcode File");
        System.out.println("2. 2000 Postcode File");
        System.out.println("3. 4000 Postcode File");
        System.out.println("4. 8000 Postcode File");
        System.out.println("5. 16000 Postcode File");
        System.out.println("");
        int input = s.nextInt();
       ArrayList<String> postcode = new ArrayList<>();
        switch(input){
            case 1: 
                File file = new File("C:\\Users\\xpemz\\OneDrive\\Documents\\London_Postcode_Test_Files\\1000_London_Postcodes.txt");
                Scanner read = new Scanner(file);
                while(read.hasNextLine()){
                String l = read.nextLine();
                postcode.add(l);
                }
                System.out.println(postcode);
                break;
            case 2:
                File file1 = new File("C:\\Users\\xpemz\\OneDrive\\Documents\\London_Postcode_Test_Files\\2000_London_Postcodes.txt");
                Scanner read1 = new Scanner(file1);
                while(read1.hasNextLine()){
                String l = read1.nextLine();
                postcode.add(l);
                }
                System.out.println(postcode);
                break;
            case 3:

                File file2 = new File("C:\\Users\\xpemz\\OneDrive\\Documents\\London_Postcode_Test_Files\\4000_London_Postcodes.txt");
                Scanner read2 = new Scanner(file2);
                while(read2.hasNextLine()){
                String l = read2.nextLine();
                postcode.add(l);
                }
                System.out.println(postcode);
                break;
            case 4:

                File file3 = new File("C:\\Users\\xpemz\\OneDrive\\Documents\\London_Postcode_Test_Files\\8000_London_Postcodes.txt");
                Scanner read3 = new Scanner(file3);
                while(read3.hasNextLine()){
                String l = read3.nextLine();
                postcode.add(l);
                }
                System.out.println(postcode);
                break;
            case 5:
                File file4 = new File("C:\\Users\\xpemz\\OneDrive\\Documents\\London_Postcode_Test_Files\\4000_London_Postcodes.txt");
                Scanner read4 = new Scanner(file4);
                while(read4.hasNextLine()){
                String l = read4.nextLine();
                postcode.add(l);
                }
                System.out.println(postcode);
                break;
        } 
              
        return postcode;
    }
    public void useHeap(ArrayList<String> postcode){
        Scanner s = new Scanner(System.in);
        MinHeap heap = new MinHeap(postcode.size());
        
        for(int n = 0 ; n < postcode.size() - 1 ; n++){
            
            heap.insert(postcode.get(n));
           
        }
        System.out.println("What operation would you like to carry out on this MinHeap");
        System.out.println("1. Find the number of elements?");
        System.out.println("2. Insert a Element?");
        System.out.println("3. Extract the minimum?");
        System.out.println("4. Search if an element exist in this structure?");
        System.out.println("5. Print all the postcodes in the file in alphabetical order?");
        int input = s.nextInt();
        switch (input){
            case 1:
                System.out.println("The number of postcodes in the heap are :" + heap.count());
                break;
            case 2:
                System.out.println("Please enter the postcode you would like to insert: ");
                heap.insert(s.nextLine());
                System.out.println("The new heap is in this order:");
                System.out.print(heap.toString());
                break;
            case 3:
                System.out.println("Extracting Minimum:");
                System.out.println("New Heap order");
                System.out.println(heap.toString());
                break;
            case 4:
                System.out.println("Please enter the element you would like to search:");
                String input2 = s.next();
               if (heap.Search(input2) == true){
                   System.out.println(input2 + " is in the minheap.");
               }
               else
               {
                   System.out.println("That postcode is not in the heap");
               }
                break;
            case 5:
                System.out.println(heap.InOrder());
                break;
            
        }
    }
    public void useBST(ArrayList<String> postcodes){
        Scanner s = new Scanner(System.in);
        BinaryTree Tree = new BinaryTree();
        
            for (int i = 1; i < postcodes.size(); i++) {
                Tree.Insert(postcodes.get(i));
        }
 
        
        System.out.println("What operation would you like to carry out on the BST");
        System.out.println("1. Find the number of elements?");
        System.out.println("2. Insert a Element?");
        System.out.println("3. Delete an element?");
        System.out.println("4. Search if an element exist in this structure?");
        System.out.println("5. Print all the postcodes in the file in alphabetical order?");
        
        int input = s.nextInt();
        switch (input){
            case 1:
                System.out.println("The number of postcodes in the heap are :" + Tree.getCount());
                break;
            case 2:
                System.out.println("Please enter the postcode you would like to insert: ");
                Tree.Insert(s.nextLine());
                System.out.println("The new heap is in this order:");
                System.out.print(Tree.toString());
                break;
            case 3:
                System.out.println("Extracting Minimum:");
                System.out.println("New Heap order");
                System.out.println(Tree.toString());
                break;
            case 4:
                System.out.println("Please enter the element you would like to search:");
                String input2 = s.next();
               if (Tree.Search(input2) == true){
                   System.out.println(input2 + " is in the minheap.");
               }
               else
               {
                   System.out.println("That postcode is not in the heap");
               }
                break;
            case 5:
                System.out.println(Tree.InOrder());
                break;
            
        }
    }
        public void useAVL(ArrayList<String> postcodes){
        Scanner s = new Scanner(System.in);
                AVLTree Tree = new AVLTree();
        
            for (int i = 1; i < postcodes.size(); i++) {
                Tree.Insert(postcodes.get(i));
        }
        
        System.out.println("What operation would you like to carry out on the AVL Tree");
        System.out.println("1. Find the number of elements?");
        System.out.println("2. Insert a Element?");
        System.out.println("3. Delete an element?");
        System.out.println("4. Search if an element exist in this structure?");
        System.out.println("5. Print all the postcodes in the file in alphabetical order?");
        
        int input = s.nextInt();
        switch (input){
            case 1:
                System.out.println("The number of postcodes in the heap are :" + Tree.getCount());
                break;
            case 2:
                System.out.println("Please enter the postcode you would like to insert: ");
                Tree.Insert(s.nextLine());
                System.out.println("The new heap is in this order:");
                System.out.print(Tree.toString());
                break;
            case 3:
                System.out.println("Extracting Minimum:");
                System.out.println("New Heap order");
                System.out.println(Tree.toString());
                break;
            case 4:
                System.out.println("Please enter the element you would like to search:");
                String input2 = s.next();
               if (Tree.Search(input2) == true){
                   System.out.println(input2 + " is in the minheap.");
               }
               else
               {
                   System.out.println("That postcode is not in the heap");
               }
                break;
            case 5:
                System.out.println(Tree.InOrder());
                break;
            
        }
    }
}




