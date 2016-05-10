import java.util.List;

class TestCase {
    private Integer expectedResult;
    private List<Integer> inputNumbers;

    public TestCase (Integer expectedResult, List<Integer> inputNumbers) {
        this.expectedResult = expectedResult;
        this.inputNumbers = inputNumbers;
    }

    public Integer getExpectedResult() {
        return expectedResult;
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }
}
