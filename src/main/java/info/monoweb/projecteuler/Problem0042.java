package info.monoweb.projecteuler;

import com.sun.deploy.util.OrderedHashSet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem0042 {
    public static void main(String[] args) {
        try {
            final Map<Integer, Integer> value2count = new HashMap<>();

            final String data = Files.readAllLines(Paths.get("p042_words.txt")).get(0);
            final String[] words = Arrays.stream(data.split(",")).map(
                    w -> w.substring(1, w.length() - 1)).toArray(String[]::new);

            Arrays.stream(words).forEach(word -> {
                int key = calc(word);
                value2count.put(key, value2count.getOrDefault(key, 0) + 1);
            });

            final IntStream values = value2count.keySet().stream().mapToInt(v -> v);
            final int max = values.max().orElseThrow(() -> new Exception());

            int result = 0;
            for (int n = 1; ; ++n) {
                int t = n * (n + 1) / 2;
                if (t > max) {
                    break;
                }
                if (value2count.containsKey(t)) {
                    result += value2count.get(t);
                }
            }
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int calc(String word) {
        int result = 0;
        for (char ch : word.toCharArray()) {
            result += (ch - 'A') + 1;
        }
        return result;
    }


}

