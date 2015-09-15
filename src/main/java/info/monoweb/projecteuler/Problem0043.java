package info.monoweb.projecteuler;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem0043 {
    public static void main(String[] args) {

        final List<String> digits = IntStream.rangeClosed(0, 9).mapToObj(i -> Integer.toString(i)).collect(Collectors.toList());

        final int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17 };

        long result = 0;
        for (int i = 0, n = factorial(10); i < n; ++i) {
            final List<String> tempDigits = new LinkedList<>(digits);

            int v = i;
            final StringBuffer sb = new StringBuffer();
            for (int j = 10; j >= 1; --j) {
                sb.append(tempDigits.remove(v % j));
                v /= j;
            }

            final String s = sb.toString();
            if (IntStream.range(0, 7).allMatch(x -> Integer.parseInt(s.substring(x + 1, x + 4)) % primes[x] == 0)) {
                result += Long.parseLong(s);
            }
        }

        System.out.println(result);
    }

    static int factorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; ++i) {
            result *= i;
        }
        return result;
    }

    static boolean isPandigital(long x) {
        final List<Long> digits = new ArrayList<>();
        while (x >= 1) {
            digits.add(x % 10);
            x /= 10;
        }
        digits.sort(Comparator.<Long>naturalOrder());
        return IntStream.range(0, digits.size()).allMatch(i -> digits.get(i) == i + 1);
    }
}

