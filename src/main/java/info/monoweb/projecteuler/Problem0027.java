package info.monoweb.projecteuler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem0027 {
    static final int limit = 1000;

    public static void main(String[] args) {
        int max = 0;
        int result = 0;
        for (int a = -limit + 1; a < limit; ++a) {
            for (int b = -limit + 1; b < limit; ++b) {
                for (int n = 0; ; ++n) {
                    int i = n * n + a * n + b;
                    if (!isPrime(i)) {
                        if (n > max) {
                            max = n;
                            result = a * b;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int searched = 2;
    static Set<Integer> primeNumbers = new HashSet<>(Arrays.asList(2));
    static Set<Integer> compositeNumbers = new HashSet<>();

    static boolean isPrime(int x) {
        if (searched < x) {
            for (int i = searched + 1; i <= x; ++i) {
                for (int p : primeNumbers) {
                    int j = p;
                    do {
                        j += p;
                        compositeNumbers.add(j);
                    } while(j < x);
                }
                if (!compositeNumbers.contains(i)) {
                    primeNumbers.add(i);
                }
            }
            searched = x;
        }
        return primeNumbers.contains(x);
    }
}
