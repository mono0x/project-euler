import java.util.Set;
import java.util.LinkedHashSet;
import java.util.stream.IntStream;

public class Problem0024 {
    public static void main(String[] args) {
        final int digits = 10;
        final int n = 1_000_000;

        nthPermutation(digits, n, new LinkedHashSet<Integer>());
        for (int x : result) {
            System.out.print(x);
        }
        System.out.println();
    }

    public static int count = 0;
    public static Set<Integer> result = null;

    public static void nthPermutation(int digits, int n, Set<Integer> set) {
        if (set.size() == digits) {
            if (++count == n) {
                result = new LinkedHashSet<Integer>(set);
            }
            return;
        }
        for (int i = 0; i < digits; ++i) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            nthPermutation(digits, n, set);
            set.remove(i);
        }
    }
}
