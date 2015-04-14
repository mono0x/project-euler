import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Problem0005 {
    public static void main(String[] args) {
        final int n = 20;
        final int[] result = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            for (Map.Entry<Integer, Integer> factor : primeFactorize(i).entrySet()) {
                final int k = factor.getKey();
                result[k] = Math.max(result[k], factor.getValue());
            }
        }

        int x = 1;
        for (int i = 1; i <= n; ++i) {
            x *= Math.pow(i, result[i]);
        }
        System.out.println(x);
    }

    public static Map<Integer, Integer> primeFactorize(int x) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 2, limit = x; i <= limit; ++i) {
            int j = 0;
            while (x % i == 0) {
                x /= i;
                limit /= i;
                ++j;
            }
            if (j > 0) {
                result.put(i, j);
            }
        }
        result.put(1, 1);
        return result;
    }
}
