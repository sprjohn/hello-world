package com.john.specs;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
Partition adults and kids
 */
public class PartitioningSpec {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = partitionAdults(collection);

        assertTrue(result.get(true).containsAll((asList(viktor, eva))));
        assertEquals(2, result.get(true).size());
        assertTrue(result.get(false).contains(sara));
        assertEquals(1, result.get(false).size());
    }

//    private Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
//        final Map<Boolean, List<Person>> result = new HashMap<>();
//        final List<Person> adults = new ArrayList<>();
//        final List<Person> children = new ArrayList<>();
//
//        for (Person person : collection) {
//            if (isAdult(person)) {
//                adults.add(person);
//            } else {
//                children.add(person);
//            }
//        }
//
//        result.put(true, Collections.unmodifiableList(adults));
//        result.put(false, Collections.unmodifiableList(children));
//
//        return result;
//    }

    private Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
        return collection.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() >= 18));
    }

    private boolean isAdult(Person person) {
        return person.getAge() >= 18;
    }
}
