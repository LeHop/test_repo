package strems;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hoppe
 */
public class IntSummaryStatisticsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> persons
                = Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        IntSummaryStatistics ageSummary
                = persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
    }

}
