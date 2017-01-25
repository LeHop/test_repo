/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author leho
 */
public class TestGuava {

    protected void partition(List<String> listToBatch){
        List<List<String>> batch = Lists.partition(listToBatch,9);
        for(List<String>list:batch){
            System.out.println(list);
        }
    }
    
    protected Integer optionalSum(Optional<Integer> a, Optional<Integer> b){
        Integer value1 = a.or(0);	
        Integer value2 = b.get();
        return value1 + value2;
    } 
    
    protected void ordering(List<Integer> list, Ordering ordering){
        Collections.sort(list, ordering.nullsFirst());
        System.out.println(list);
        list = ImmutableList.copyOf(Iterables.filter(list, Predicates.notNull()));
        System.out.println("Min.:"+ordering.min(list));
        System.out.println("Max.:"+ordering.max(list));
    } 
    
    protected void printRange(Range<Integer> range) {		
   
      System.out.print("[ ");
      
      for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
         System.out.print(grade +" ");
      }
      System.out.println("]");
   }
    
}
