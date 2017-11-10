package lambda;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hoppe
 */
public class Short {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((a, b) -> b.compareTo(a));
        System.out.println(names);
    }
}
