package info.monoweb.projecteuler;

public class Problem0015 {
    public static void main(String[] args) {
        final int n = 20;

        System.out.println(combination(2 * n, n));
    }

    public static long combination(int n, int m) {
        boolean[] divided = new boolean[m + 1];

        long result = 1;
        for (int i = m + 1; i <= n; ++i) {
            int mul = i;
            for (int j = 2; j <= m; ++j) {
                if (!divided[j] && mul % j == 0) {
                    divided[j] = true;
                    mul /= j;
                }
            }
            result *= mul;
        }
        for (int i = 2; i <= m; ++i) {
            if (!divided[i]) {
                result /= i;
            }
        }
        return result;
    }
}

