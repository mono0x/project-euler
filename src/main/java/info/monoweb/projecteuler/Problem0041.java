package info.monoweb.projecteuler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Problem0041 {
    public static void main(String[] args) {
        final boolean[] table = new boolean[987654321 + 1];

        IntStream.rangeClosed(2, 987654321).forEach(i -> {
            if (!table[i]) {
                for (int j = i * 2; j <= 987654321; j += i) {
                    table[j] = true;
                }
            }
        });
        for (int i = 987654321; i >= 2; --i) {
            if (table[i]) {
                continue;
            }
            if (isPandigital(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPandigital(int x) {
        final List<Integer> digits = new ArrayList<>();
        while (x >= 1) {
            digits.add(x % 10);
            x /= 10;
        }
        digits.sort(Comparator.<Integer>naturalOrder());
        return IntStream.range(0, digits.size()).allMatch(i -> digits.get(i) == i + 1);
    }
}

