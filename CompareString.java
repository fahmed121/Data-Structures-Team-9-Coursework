/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures.group3;
import java.util.Comparator;
 
public class CompareString implements Comparator<String>{
 
 
    @Override
    public int compare(String o1, String o2) {
        int res = o1.compareTo(o2);
        return res;    
    }
    
}