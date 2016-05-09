import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by john on 5/9/16.
 */
public class TimingFun {
    public static void main(String... args) {
        String[] array = new String[1000000];
        Arrays.fill(array, "AbabagalamagA");
        System.out.println("Warmup...");
        for (int i = 0; i < 100; ++i) {
            sequential(array);
            parallel(array);
        }
        System.out.println("Benchmark...");
        for (int i = 0; i < 20; ++i) {
            System.out.printf("Run %d:  sequential %s  -  parallel %s\n",
                    i,
                    test(() -> sequential(array)),
                    test(() -> parallel(array)));
        }
    }
    private static void sequential(String[] array) {
        Arrays.stream(array).map(String::toLowerCase).collect(Collectors.toList());
    }
    private static void parallel(String[] array) {
        Arrays.stream(array).parallel().map(String::toLowerCase).collect(Collectors.toList());
    }
    private static String test(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long elapsed = System.currentTimeMillis() - start;
        return String.format("%4.2fs", elapsed / 1000.0);
    }
}
