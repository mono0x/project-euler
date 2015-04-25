package info.monoweb.projecteuler;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem0029 {
    static final int n = 100;

    public static void main(String[] args) {
        final Set<BigInteger> terms = IntStream.rangeClosed(2, n)
                .mapToObj(a -> new BigInteger(String.valueOf(a)))
                .flatMap((final BigInteger a) ->
                        IntStream.rangeClosed(2, n).mapToObj(b -> a.pow(b)))
                .collect(Collectors.toSet());

        System.out.println(terms.size());
    }
}
