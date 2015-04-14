public class Problem0001 {
    public static void main(String[] args) {
        final int max = 1000;
        System.out.println(sumN(3, max) + sumN(5, max) - sumN(15, max));
    }

    public static int sumN(int n, int max) {
        final int limit = (max - 1) / n;
        return limit * (limit + 1) / 2 * n;
    }
}
