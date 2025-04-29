
package data.structures.group3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author xpemz
 */
public class MainMenu {
    
    
    
    
    
    
    
    
    
    
    
    
    
public static void main(String[] args) throws FileNotFoundException {
    Scanner s = new Scanner(System.in);
    MenuSystem Menu = new MenuSystem();
    
    ArrayList<String> check = Menu.ChooseFile();
    
    System.out.println("Which Data structure would you like to use");
    System.out.println("1. Min Heap");
    System.out.println("2. Binary Search Tree");
    System.out.println("3. AVL Tree");
    System.out.println("4. Benchmark All");
    int input = s.nextInt();
    
    switch(input){
        case 1: 
            Menu.useHeap(check);
            break;
        case 2:
            Menu.useBST(check);
            break;
        case 3:
            Menu.useAVL(check);
            break;
        case 4:
            
            break;

    }
        
    
    
    
    
    
    
    }
    
}
