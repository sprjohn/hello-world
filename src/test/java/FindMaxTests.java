import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindMaxTests {
    private TestCase testCase;

    public FindMaxTests(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameters(name = "Test {index}: shouldReturnSumFromList")
    public static List<TestCase> getTestCases() {
        return Arrays.asList(
                new TestCase(1, Collections.singletonList(1)),
                new TestCase(9, Arrays.asList(1,3,5,9,8,3)),
                new TestCase(5, Arrays.asList(-1,3,5,-9,-8,-3))
        );
    }

    @Test
    public void shouldReturnMaxFromList() {
        Integer expectedResult = testCase.getExpectedResult();

        assertEquals("Should have returned " + expectedResult + " as the max", expectedResult,
                Main.findMax(testCase.getInputNumbers()));
    }
}
