package com.john.specs;

import org.junit.Test;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/*
Get people statistics: average age, count, maximum age, minimum age and sum og all ages.
 */
public class PeopleStatsSpec {

    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    List<Person> collection = asList(sara, eva, viktor);

    @Test
    public void getStatsShouldReturnAverageAge() {
        assertEquals((double)(4 + 40 + 42) / 3, getStats(collection).getAverage(), 0.0);
    }

    @Test
    public void getStatsShouldReturnNumberOfPeople() {
        assertEquals(3, getStats(collection).getCount(), 0.0);
    }

    private DoubleSummaryStatistics getStats(List<Person> collection) {
        return collection.stream()
                .mapToDouble(Person::getAge)
                .summaryStatistics();
    }

    @Test
    public void getStatsShouldReturnMaximumAge() {
        assertEquals(42, getStats(collection).getMax(), 0.0);
    }

    @Test
    public void getStatsShouldReturnMinimumAge() {
        assertEquals(4, getStats(collection).getMin(), 0.0);
    }

    @Test
    public void getStatsShouldReturnSumOfAllAges() {
        assertEquals(40 + 42 + 4, getStats(collection).getSum(), 0.0);
    }

}
