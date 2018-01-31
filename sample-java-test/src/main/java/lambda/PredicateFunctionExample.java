/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author hoppe
 */
public class PredicateFunctionExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Predicate<Integer> positive = i -> i > 0;
        
        List<Integer> integerList = Arrays.asList(
                new Integer(1), new Integer(10),
                new Integer(200), new Integer(101),
                new Integer(-10), new Integer(0));
        
        List<Integer> filteredList = filterList(integerList, positive);
        
        filteredList.forEach(System.out::println);
    }

    public static List<Integer> filterList(List<Integer> listOfIntegers, Predicate<Integer> predicate) {
        List<Integer> filteredList = new ArrayList<Integer>();
        for (Integer integer : listOfIntegers) {
            if (predicate.test(integer)) {
                filteredList.add(integer);
            }
        }
        return filteredList;
    }
}
