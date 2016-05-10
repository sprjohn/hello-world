package com.john.specs;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

/*
Convert elements of a collection to upper case.
 */
public class ToUpperCaseSpec {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertTrue(transform(collection).containsAll(expected));
    }

    private static List<String> transform(List<String> collection) {
        return collection.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

}