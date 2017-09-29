/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author hoppe
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("----------");
        
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });
        
        for (String name : names) {
            System.out.println(name);
        }
        
        System.out.println("----------");
        
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        
        for (String name : names) {
            System.out.println(name);
        }
        
    }

}
