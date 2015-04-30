package info.monoweb.projecteuler;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem0034 {
    public static void main(String[] args) {
        final int[] fact = new int[10];
        fact[0] = fact[1] = 1;
        IntStream.rangeClosed(2, 9).forEach(i -> {
            fact[i] = fact[i - 1] * i;
        });

        final int result = IntStream.rangeClosed(3, Arrays.stream(fact).sum()).map(i -> {
            int sum = 0;
            for (int v = i; v > 0; v /= 10) {
                sum += fact[v % 10];
            }
            if (i == sum) {
                return i;
            }
            return 0;
        }).sum();

        System.out.println(result);
    }


}
