package info.monoweb.projecteuler;

import java.util.Map;
import java.util.HashMap;

public class Problem0014 {
    public static void main(String[] args) {
        final int limit = 1_000_000;

        int max = 0;
        int answer = 0;

        Map<Long, Integer> cache = new HashMap<>();
        cache.put(1l, 1);

        for (int i = 1; i < limit; i += 2) {
            int length = next(i, cache);
            if (length > max) {
                max = length;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static int next(long i, Map<Long, Integer> cache) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        final int l = next(i % 2 == 0 ? i / 2 : 3 * i + 1, cache) + 1;
        cache.put(i, l);
        return l;
    }
}
