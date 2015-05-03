package info.monoweb.projecteuler;

import java.util.stream.IntStream;

public class Problem0036 {
    public static void main(String[] args) {
        final int n = 1_000_000;
        final int result = IntStream.range(1, n).filter(i ->
                isPaldromic(Integer.toString(i)) && isPaldromic(Integer.toString(i, 2))).sum();
        System.out.println(result);
    }

    static boolean isPaldromic(String s) {
        final int n = s.length();
        return IntStream.range(0, n / 2).allMatch(i -> s.charAt(i) == s.charAt(n - i - 1));
    }
}
