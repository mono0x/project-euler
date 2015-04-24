package info.monoweb.projecteuler;

public class Problem0010 {
    public static void main(String[] args) {
        final int max = 2_000_000 - 1;

        final boolean[] table = new boolean[max + 1];
        table[1] = true;

        long sum = 0;
        for (int i = 1; i <= max; ++i) {
            if (table[i]) {
                continue;
            }
            for (int j = i * 2; j <= max; j += i) {
                table[j] = true;
            }
            sum += i;
        }
        System.out.println(sum);
    }
}

