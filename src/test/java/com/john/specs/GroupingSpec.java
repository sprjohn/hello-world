package com.john.specs;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
Group people by nationality
 */
public class GroupingSpec {

    @Test
    public void ShouldGroupPeopleByNationality() {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, List<Person>> result = groupByNationality(collection);

        List<Person> norwegians = result.get("Norwegian");
        assertTrue(norwegians.containsAll(asList(sara, eva)));
        assertEquals(2, norwegians.size());

        List<Person> serbians = result.get("Serbian");
        assertTrue(serbians.contains(viktor));
        assertEquals(1, serbians.size());
    }

    private Map<String, List<Person>> groupByNationality(List<Person> collection) {
        return collection.stream()
                .collect(Collectors.groupingBy(Person::getNationality));
    }

}
