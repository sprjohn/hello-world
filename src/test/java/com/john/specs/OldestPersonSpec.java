package com.john.specs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Get oldest person from the collection
 */
public class OldestPersonSpec {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = Arrays.asList(sara, eva, viktor);
        assertEquals(eva, getOldestPerson(collection));
    }

    private Person getOldestPerson(List<Person> collection) {
        return collection.stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
    }
}
