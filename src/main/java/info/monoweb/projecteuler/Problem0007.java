package info.monoweb.projecteuler;

import java.util.List;
import java.util.ArrayList;

public class Problem0007 {
    public static void main(String[] args) {
        final int n = 10_001;
        final List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 1; i < n; ++i) {
            addNextPrime(primes);
        }
        System.out.println(primes.get(primes.size() - 1));
    }

    public static void addNextPrime(List<Integer> primes) {
        final int last = primes.get(primes.size() - 1);
        for (int i = last + 1; ; ++i) {
            final int target = i;
            if (primes.stream().noneMatch(x -> target % x == 0)) {
                primes.add(i);
                break;
            }
        }
    }
}
