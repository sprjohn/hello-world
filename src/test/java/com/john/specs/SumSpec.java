package com.john.specs;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/*
Sum all elements of a collection
 */
public class SumSpec {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertEquals(15, calculate(numbers));
    }

    private int calculate(List<Integer> numbers) {
        return numbers.stream()
//                .reduce(0, (a, b) -> a + b);
                .mapToInt(n -> n)
                .sum();
    }

}
