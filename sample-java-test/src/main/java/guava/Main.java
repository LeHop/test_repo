package guava;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hoppe
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isPositive = (Integer number) -> number > 0;
        if (Iterables.all(numbers, isPositive)) {
            System.out.println("Tak, wszystkie są dodatnie");
        }
       
        Predicate<String> predicate = (s) -> s.length() > 0;
        Predicate<String> predicate1 = (s) -> s.length() > 3;
        System.out.println(predicate.and(predicate1).test("Kot"));
    }

}
