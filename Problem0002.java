public class Problem0002 {
    public static void main(String[] args) {
        final int max = 4_000_000;
        int a = 0;
        int b = 1;
        int sum = 0;

        for (; ; ) {
            int current = a + b;
            if (current >= max) {
                break;
            }
            a = b;
            b = current;
            if (current % 2 == 0) {
                sum += current;
            }
        }

        System.out.println(sum);
    }
}
