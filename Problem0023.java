import java.util.Set;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Problem0023 {
    public static void main(String[] args) {
        final int n = 28123;

        final int[] abundantNumbers =
            IntStream.rangeClosed(2, n).filter(i -> isAbundantNumber(i)).toArray();
        final Set<Integer> writableNumbers = new HashSet<>();

        for (int x : abundantNumbers) {
            for (int y : abundantNumbers) {
                writableNumbers.add(x + y);
            }
        }

        final int result = IntStream.rangeClosed(1, n).filter(x -> !writableNumbers.contains(x)).sum();
        System.out.println(result);
    }

    public static boolean isAbundantNumber(int x) {
        return IntStream.range(1, x).filter(i -> x % i == 0).sum() > x;
    }
}
