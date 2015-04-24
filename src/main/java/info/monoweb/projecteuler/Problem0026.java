package info.monoweb.projecteuler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

public class Problem0026 {
    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class DivideResult {
        private int quotient;
        private int remainder;
    }

    public static void main(String[] args) {
        final int n = 1000;

        int maxValue = 0;
        int maxLength = 0;

        for (int d = 2; d < n; ++d) {
            final Set<DivideResult> divideResults = new HashSet<>();

            int x = 10;
            for (int length = 0; x != 0; ++length) {
                final DivideResult divideResult = new DivideResult(x / d, x % d);
                if (divideResults.contains(divideResult)) {
                    if (length > maxLength) {
                        maxLength = length;
                        maxValue = d;
                    }
                    break;
                }
                divideResults.add(divideResult);

                x -= d * divideResult.getQuotient();
                x *= 10;
            }

        }
        System.out.print(maxValue);
    }
}
