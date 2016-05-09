import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by john on 5/6/16.
 */
public class MainTest {
    @Before
    public void setup() {}

    @Test
    public void foo() {
        List<Person> roster = getPeople();

        Main.printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }

    int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    @Test
    public void bar() {
        IntegerMath addition = (a, b) -> a + b;

        System.out.println(operateBinary(4, 5, addition));

        addition = (a, b) -> a - b;

        System.out.println(operateBinary(4, 5, addition));
    }

    private List<Person> getPeople() {
        return Arrays.asList(getPerson("A"), getPerson("B"), getPerson("C"));
    }

    private Person getPerson(String firstName) {
        Person person = new Person();
        person.setEmailAddress(firstName + "@localhost");
        person.setName("Mr. " + firstName);
        person.setAge(20);
        person.setGender(Person.Sex.MALE);

        return person;
    }

    @Test
    public void comparatorFun() {
//        Comparator<Person> personComparator = (person1, person2) -> person1.getAge().compareTo(person2.getAge());
        Comparator<Person> personComparator = Comparator.comparing(Person::getAge);

        Person person1 = new Person();
        person1.setAge(20);

        Person person2 = new Person();
        person2.setAge(21);

        assertTrue(personComparator.compare(person1, person2) <= 0);
    }

    @Test
    public void simpleSum() {
        int expectedValue = 12;

        assertEquals(expectedValue, Main.sumNumbers(Arrays.asList(4,7,1), number -> true));
    }

    @Test
    public void sumOnlyEven() {
        int expectedValue = 12;

        assertEquals(expectedValue, Main.sumNumbers(Arrays.asList(4,3,6,2,7), number -> number % 2 == 0));
    }

    @Test
    public void sumOnlyOdd() {
        int expectedValue = 10;

        assertEquals(expectedValue, Main.sumNumbers(Arrays.asList(4,3,6,2,7), number -> number % 2 != 0));
    }

    @Test
    public void timingFun() {
        final long iterations = 1000;
        final int numberOfPeople = 50000;

        List<Person> personList = getSpecifiedNumberOfPeople(numberOfPeople);

        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            Main.parallelSort(personList);
        }
        final long endTime = System.currentTimeMillis();

        System.out.println("Average time:\t" + (endTime - startTime)*1.00/iterations);
    }

    private List<Person> getSpecifiedNumberOfPeople(int numberOfPeople) {
        List<Person> people = new ArrayList<>(numberOfPeople);

//        for (int i = numberOfPeople; i > 0; i--) {
        for (int i = 0; i < numberOfPeople; i++) {
            people.add(new Person(i));
        }

        return people;
    }
}
