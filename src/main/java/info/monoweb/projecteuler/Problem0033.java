package info.monoweb.projecteuler;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem0033 {
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Fraction {
        int numerator;
        int denominator;

        double getValue() {
            return (double)numerator / denominator;
        }

        Fraction reduce() {
            int d = denominator;
            int n = numerator;
            for (int i = 2; i <= d; ++i) {
                while (n % i == 0 && d % i == 0) {
                    n /= i;
                    d /= i;
                }
            }
            return new Fraction(n, d);
        }

        Fraction multiply(Fraction f) {
            return new Fraction(numerator * f.numerator, denominator * f.denominator);
        }
    }

    public static void main(String[] args) {
        final Fraction result = IntStream.rangeClosed(11, 99).mapToObj(Integer::valueOf).flatMap(d -> {
            return IntStream.rangeClosed(10, d - 1).mapToObj(n -> new Fraction(n, d)).filter(f -> {
                final int n1 = f.numerator % 10;
                final int n2 = f.numerator / 10;
                final int d1 = f.denominator % 10;
                final int d2 = f.denominator / 10;
                if (n1 != 0 && n1 == d1 && test(f, new Fraction(n2, d2))) {
                    return true;
                }
                if (n2 != 0 && n2 == d2 && test(f, new Fraction(n1, d1))) {
                    return true;
                }
                if (n1 != 0 && n1 == d2 && test(f, new Fraction(n2, d1))) {
                    return true;
                }
                if (n2 != 0 && n2 == d1 && test(f, new Fraction(n1, d2))) {
                    return true;
                }
                return false;
            });
        }).reduce(new Fraction(1, 1), (l, r) -> l.multiply(r));
        System.out.println(result.reduce().denominator);
    }

    static boolean test(Fraction f, Fraction sf) {
        return f.reduce().equals(sf.reduce());
    }
}
