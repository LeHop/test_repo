/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strems;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

/**
 *
 * @author hoppe
 */
public class CollectorTest {

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
                        new Person("Max", 23),
                        new Person("David", 12));

        Collector<Person, StringJoiner, String> personNameCollector
                = Collector.of(
                        () -> new StringJoiner(" | "), // supplier
                        (j, p) -> j.add(p.name.toUpperCase()), // accumulator
                        (j1, j2) -> j1.merge(j2), // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
    }

}
