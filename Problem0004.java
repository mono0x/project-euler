public class Problem0004 {
    public static void main(String[] args) {
        int max = 0;
        for (int x = 999; x >= 100; --x) {
            for (int y = x; y >= 100; --y) {
                final int product = x * y;
                if (product % 10 != product / 100000 % 10) {
                    continue;
                }
                if (product / 10 % 10 != product / 10000 % 10) {
                    continue;
                }
                if (product / 100 % 10 != product / 1000 % 10) {
                    continue;
                }
                max = Math.max(max, product);
            }
        }
        System.out.println(max);
        return;
    }
}
