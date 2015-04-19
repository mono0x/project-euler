import java.util.Map;
import java.util.HashMap;

public class Problem0021 {
    public static void main(String[] args) {
        final int n = 10_000;

        final Map<Integer, Integer> ds = new HashMap<>();

        int sum = 0;
        for (int i = 1; i < n; ++i) {
            final int dv = d(i);
            if (i == dv) {
                continue;
            }
            if (dv > i) {
                ds.put(dv, i);
            }
            else if (ds.containsKey(i) && ds.get(i) == dv) {
                sum += i + dv;
            }
        }
        System.out.println(sum);
    }

    public static int d(int x) {
        int sum = 1;
        for (int i = 2, n = x / 2; i <= n; ++i) {
            if (x % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
