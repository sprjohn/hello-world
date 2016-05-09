import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by john on 5/6/16.
 */
public class Main {
    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }

        System.out.println("---");
        roster.forEach(Person::printPerson);
        roster.forEach(System.out::println);
    }

    public static int sumNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        int sum = 0;

        for (Integer i : numbers) {
            if (predicate.test(i)) {
                sum += i;
            }
        }

        return sum;
    }

    public static List<Person> serialSort(List<Person> people) {
        return people.stream()
                     .sorted(Comparator.comparing(Person::getAge))
                     .collect(toList());
    }

    public static List<Person> parallelSort(List<Person> people) {
        return people.parallelStream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(toList());
    }
}
