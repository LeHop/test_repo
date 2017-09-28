/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author hoppe
 */
public class Joining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> persons
                = Arrays.asList(
                        new Person("Max", 18),
                        new Person("Samanta", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("John", 23),
                        new Person("David", 12));

        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);

        //map
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);

    }

}
