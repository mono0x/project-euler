public class Problem0012 {
    public static void main(String[] args) {
        final int n = 500;

        for (int number = 1, increment = 2; ; number += increment, ++increment) {
            int divisors = countDivisors(number);
            if (divisors >= n) {
                System.out.println(number);
                return;
            }
        }
    }

    public static int countDivisors(int input) {
        int result = 1;
        for (int i = 2; i <= input && input > 1; ++i) {
            int j = 1;
            for (; input % i == 0; ++j) {
                input /= i;
            }
            result *= j;
        }
        return result;
    }
}
