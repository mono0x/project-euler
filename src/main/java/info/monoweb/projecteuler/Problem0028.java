package info.monoweb.projecteuler;

import java.util.stream.IntStream;

public class Problem0028 {
    static final int n = 1001;

    public static void main(String[] args) {
        final int[] table = new int[n * n];
        final int[] dirs = { 1, n, -1, -n };

        {
            int dir = 0;
            int current = n / 2 + (n / 2) * n;
            int turn = 0;
            int nextTurn = 1;
            int turnCount = 0;
            for (int steps = 1; steps <= n * n; ++steps) {
                table[current] = steps;
                current += dirs[dir];
                if (++turn == nextTurn) {
                    if (++turnCount % 2 == 0) {
                        ++nextTurn;
                    }
                    dir = (dir + 1) % 4;
                    turn = 0;
                }
            }
        }

        final int result =
                IntStream.range(0, n).map(i -> table[i + i * n] + table[(n - i - 1) + i * n]).sum() - 1;
        System.out.println(result);
    }

    static int index(int x, int y) {
        return y * (n + 2) + x;
    }
}
