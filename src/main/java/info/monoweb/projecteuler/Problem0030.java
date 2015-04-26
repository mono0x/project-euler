package info.monoweb.projecteuler;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem0030 {
    public static void main(String[] args) {
        final int n = 5;
        final int maxDigits = getMaxDigits(n);
        final int[] dividers = IntStream.range(0, maxDigits).map(i -> pow(10, i)).toArray();

        final int answer = IntStream.range(2, pow(9, n) * maxDigits).filter(i -> {
            final int sum = Arrays.stream(dividers).map(d -> pow(i / d % 10, n)).sum();
            return sum == i;
        }).sum();
        System.out.println(answer);
    }

    static int getMaxDigits(final int n) {
        for (int i = 1; ; ++i) {
            if (pow(9, n) * i < pow(10, i)) {
                return i;
            }
        }
    }

    static int pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; ++i) {
            result *= a;
        }
        return result;
    }
}
