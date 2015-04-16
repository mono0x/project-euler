public class Problem0009 {
    public static void main(String[] args) {
        final int sum = 1000;
        for (int c = sum - 2; c >= 3; --c) {
            for (int b = c - 1; b >= 2; --b) {
                int a = 1000 - b - c;
                if (a <= 0 || a + b + c != 1000) {
                    continue;
                }
                if (a * a + b * b == c * c) {
                    System.out.println(a * b * c);
                    return;
                }
            }
        }
    }
}
