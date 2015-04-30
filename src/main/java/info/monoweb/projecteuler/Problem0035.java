package info.monoweb.projecteuler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem0035 {
    public static void main(String[] args) {
        final int n = 1_000_000;

        final boolean[] composites = new boolean[n + 1];
        IntStream.rangeClosed(2, n).forEach(i -> {
            if (!composites[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    composites[j] = true;
                }
            }
        });

        final Set<Integer> circulars = new HashSet<>();
        IntStream.rangeClosed(2, n).forEach(i -> {
            if (circulars.contains(i)) {
                return;
            }

            final String s = String.valueOf(i);
            final Set<Integer> rotations = IntStream.range(0, s.length())
                    .map(x -> Integer.parseInt(s.substring(x) + s.substring(0, x)))
                    .boxed()
                    .collect(Collectors.toSet());
            if (rotations.stream().allMatch(x -> !composites[x])) {
                circulars.addAll(rotations);
            }
        });
        System.out.println(circulars.size());
    }

}
