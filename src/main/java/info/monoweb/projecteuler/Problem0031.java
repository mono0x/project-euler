package info.monoweb.projecteuler;

import java.util.stream.IntStream;

public class Problem0031 {
    static final int[] availableCoins = {1, 2, 5, 10, 20, 50, 100, 200,};
    static final int n = 200;

    public static void main(String[] args) {
        final int result = countPatterns(0, 0);
        System.out.println(result);
    }

    static int countPatterns(int value, int current) {
        if (value > n) {
            return 0;
        }
        else if (value == n) {
            return 1;
        }
        else {
            return IntStream.range(current, availableCoins.length).map(i ->
                    countPatterns(value + availableCoins[i], i)).sum();
        }
    }
}
