package info.monoweb.projecteuler;

public class Problem0003 {
    public static void main(String[] args) {
        final long target = 600_851_475_143l;
        final long sqrtTarget = (long)Math.sqrt(target);

        long primeFactor = 0;

        long x = target;
        for (long i = 2; i <= sqrtTarget; ++i) {
            if (x % i == 0) {
                x /= i;
                primeFactor = i;
            }
        }

        System.out.println(primeFactor);
    }
}

