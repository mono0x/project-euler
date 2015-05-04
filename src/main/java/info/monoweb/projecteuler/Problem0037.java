package info.monoweb.projecteuler;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Problem0037 {
    static Set<Integer> primes = new HashSet<>();
    static int searched = 0;

    public static void main(String[] args) {
        primes.add(2);
        searched = 2;

        int sum = 0;
        int count = 0;
        for (int i = 13; count < 11; ++i) {
            if (isTruncatablePrime(i)) {
                System.out.println(i);
                ++count;
                sum += i;
            }
        }
        System.out.println(sum);
    }

    static boolean isTruncatablePrime(int n) {
        if (!isPrime(n)) {
            return false;
        }
        final String s = String.valueOf(n);
        return IntStream.range(1, s.length()).allMatch(i ->
                isPrime(Integer.valueOf(s.substring(0, i))) &&
                isPrime(Integer.valueOf(s.substring(i)))
        );
    }

    static boolean isPrime(int n) {
        if (searched < n) {
            do {
                final int target = ++searched;
                if (primes.stream().noneMatch(x -> target % x == 0)) {
                    primes.add(searched);
                }
            }
            while (searched < n);
        }
        return primes.contains(n);
    }
}
