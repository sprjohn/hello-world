import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }

        roster.stream().filter(tester::test).forEach(p -> {
            String data = mapper.apply(p);
            block.accept(data);
        });

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

    public static Integer findMax(List<Integer> numbers) {
//        int max = 0;
//
//        for (int number : numbers) {
//            if (number > max) {
//                max = number;
//            }
//        }
//
//        return max;

//        return numbers.stream().max(Comparator.comparing(n -> n)).get();
        return numbers.stream().max(Comparator.naturalOrder()).get();
//        return numbers.stream().reduce(0, Integer::max);
//        return numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
    }

    public static Integer findSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
//        return numbers.stream().reduce(0, (a, b) -> a + b);
    }
}
