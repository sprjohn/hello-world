package com.john.specs;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/*
Return people names separated by comma
 */
public class JoiningSpec {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);

        assertEquals("Names: Sara, Viktor, Eva.", namesToString(collection));
    }

    private String namesToString(List<Person> collection) {
        return collection.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
    }

}
