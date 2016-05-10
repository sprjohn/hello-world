import org.junit.Test;

import java.util.stream.IntStream;

public class FooTest {
    @Test
    public void foo() {
        IntStream.rangeClosed(1, 50)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    public void oldWay() {
        for (int i = 0; i <= 50; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
