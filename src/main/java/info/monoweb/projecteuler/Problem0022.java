package info.monoweb.projecteuler;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Problem0022 {
    public static void main(String[] args) {
        try {
            final String data = Files.readAllLines(Paths.get("p022_names.txt")).get(0);
            final String[] names = Arrays.stream(data.split(",")).map(
                    name -> name.substring(1, name.length() - 1)).toArray(String[]::new);

            final int[] scores = Arrays.stream(names).sorted().mapToInt(n ->
                    n.chars().map(c -> c - 'A' + 1).sum()).toArray();

            int sum = 0;
            for (int i = 0, n = scores.length; i < n; ++i) {
                sum += (i + 1) * scores[i];
            }
            System.out.println(sum);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
