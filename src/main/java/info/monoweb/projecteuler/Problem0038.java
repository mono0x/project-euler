package info.monoweb.projecteuler;

import java.util.stream.IntStream;

public class Problem0038 {
    public static void main(String[] args) {
        final int max = IntStream.rangeClosed(1, 9876).mapToObj(i -> {
            final StringBuilder sb = new StringBuilder();
            for (int j = 1; ; ++j) {
                sb.append(i * j);
                final String s = sb.toString();
                if (reject(s)) {
                    break;
                }
                final int l = s.length();
                if (l < 9) {
                    continue;
                }
                if (l > 9) {
                    break;
                }
                return Integer.valueOf(s);
            }
            return null;
        }).mapToInt(i -> i != null ? i.intValue() : Integer.MIN_VALUE).max().getAsInt();
        System.out.println(max);
    }

    static boolean reject(String s) {
        final char[] chars = s.toCharArray();
        for (int i = 0, n = chars.length; i < n - 1; ++i) {
            if (chars[i] == '0') {
                return true;
            }
            for (int j = i + 1; j < n; ++j) {
                if (chars[i] == chars[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
