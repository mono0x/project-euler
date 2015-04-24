package info.monoweb.projecteuler;

import java.math.BigInteger;

public class Problem0020 {
    public static void main(String[] args) {
        final int n = 100;
        BigInteger fact = new BigInteger("1");
        for (int i = 2; i <= n; ++i) {
            fact = fact.multiply(new BigInteger(Integer.toString(i)));
        }

        final String str = fact.toString();

        int result = 0;
        for (int i = 0, m = str.length(); i < m; ++i) {
            result += str.charAt(i) - '0';
        }
        System.out.println(result);
    }
}
