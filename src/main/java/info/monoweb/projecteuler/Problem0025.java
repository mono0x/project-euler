package info.monoweb.projecteuler;

import java.math.BigInteger;

public class Problem0025 {
    public static void main(String[] args) {
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i < 1000; ++i) {
            n = n.multiply(BigInteger.TEN);
        }

        BigInteger previous = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        for (int i = 3; ; ++i) {
            final BigInteger temp = current;
            current = current.add(previous);
            previous = temp;

            if (current.compareTo(n) >= 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
