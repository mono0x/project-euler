package info.monoweb.projecteuler;

import java.math.BigInteger;

public class Problem0016 {
    public static void main(String[] args) {
        final String str = (new BigInteger("2")).pow(1000).toString();

        int result = 0;
        for (int i = 0, n = str.length(); i < n; ++i) {
            result += str.charAt(i) - '0';
        }
        System.out.println(result);
    }
}

