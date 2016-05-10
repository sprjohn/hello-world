package com.john.specs;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
Filter collection so that only elements with less then 4 characters are returned.
 */
public class FilterCollectionSpec {

    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");

        List<String> collectionToTest = transform(collection);
        assertTrue(collectionToTest.containsAll(expected));
        assertEquals(expected.size(), collectionToTest.size());
    }

    private List<String> transform(List<String> collection) {
        return collection.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
    }

}
