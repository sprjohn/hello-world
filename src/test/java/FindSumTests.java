import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindSumTests {
    private TestCase testCase;

    public FindSumTests(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameters(name = "Test {index}: shouldReturnSumFromList")
    public static List<TestCase> getTestCases() {
        return Arrays.asList(
                new TestCase(1, Collections.singletonList(1)),
                new TestCase(9, Arrays.asList(1,3,5)),
                new TestCase(5, Arrays.asList(-1,3,5,-2,0))
        );
    }

    @Test
    public void shouldReturnSumFromList() {
        Integer expectedResult = testCase.getExpectedResult();

        assertEquals("Should have returned " + expectedResult + " as the sum", expectedResult,
                Main.findSum(testCase.getInputNumbers()));
    }
}
