
import com.google.common.base.Optional;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leho
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listToBatch = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28");
        List<Integer> integerList = Arrays.asList(1,5,3,2,4,6,7,7,8,null);
        TestGuava ga = new  TestGuava();
        System.out.println("---Partition---");
        ga.partition(listToBatch);
        
        System.out.println("---OptionalSum---");
        Integer value1 = null;
        Integer value2 = new Integer(7);
        Optional<Integer> opt1 = Optional.fromNullable(value1);
        Optional<Integer> opt2 = Optional.of(value2);
        System.out.println(ga.optionalSum(opt1,opt2));
        
        System.out.println("---Ordering --");
        ga.ordering(integerList, Ordering.natural());
        
        System.out.println("---Range --");
        
    }
    
    
    
}
