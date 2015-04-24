package info.monoweb.projecteuler;

public class Problem0006 {
    public static void main(String[] args) {
        final long n = 100;
        // divided by (n * (n + 1) / 2)
        final long sumOfSquares = (2 * n + 1) / 3;
        final long squareOfSum = n * (n + 1) / 2;
        System.out.println((squareOfSum - sumOfSquares) * n * (n + 1) / 2);
    }
}
