package com.john.specs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
Get names of all kids (under age of 18)
 */
public class KidsSpec {

    @Test
    public void getKidNameShouldReturnNamesOfAllKidsFromNorway() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        List<String> kidNames = getKidNames(collection);
        assertTrue(kidNames.containsAll(Arrays.asList("Sara", "Anna")));
        assertFalse(kidNames.contains("Eva"));
        assertFalse(kidNames.contains("Viktor"));

    }

    private List<String> getKidNames(List<Person> collection) {
        return collection.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toList());
    }

}
