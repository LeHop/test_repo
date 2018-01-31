package lambda;

import static java.util.Arrays.asList;
import java.util.List;

/**
 *
 * @author hoppe
 */
public class Wprawki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> persons = asList(new Person("Joe"), new Person("Jim"), new Person("John"));
        persons.forEach(p -> p.setLastName("Doe"));
        persons.forEach(p -> System.out.println(p.getFirstName()+" "+p.getLastName()));
        
    }
    
    
    
}
