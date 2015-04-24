package info.monoweb.projecteuler;

public class Problem0017 {
    public static final int[] letters = {
        0,
        "one".length(),
        "two".length(),
        "three".length(),
        "four".length(),
        "five".length(),
        "six".length(),
        "seven".length(),
        "eight".length(),
        "nine".length(),
        "ten".length(),
        "eleven".length(),
        "twelve".length(),
        "thirteen".length(),
        "fourteen".length(),
        "fifteen".length(),
        "sixteen".length(),
        "seventeen".length(),
        "eighteen".length(),
        "nineteen".length(),
    };

    public static final int[] ty = {
        0,
        0,
        "twenty".length(),
        "thirty".length(),
        "forty".length(),
        "fifty".length(),
        "sixty".length(),
        "seventy".length(),
        "eighty".length(),
        "ninety".length(),
    };

    public static final int and = "and".length();

    public static final int hundred = "hundred".length();

    public static final int one_thousand = "onethousand".length();

    public static void main(String[] args) {
        final int n = 1000;

        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            System.out.println(i + ":" + length(i));
            sum += length(i);
        }
        System.out.println(sum);
    }

    public static int length(int i) {
        if (i == 1000) {
            return one_thousand;
        }
        int result = 0;
        if (i >= 100) {
            result += letters[i / 100] + hundred;
            if (i % 100 != 0) {
                result += and;
            }
        }
        i %= 100;
        if (i != 0) {
            if (i <= 19) {
                result += letters[i];
            }
            else {
                result += ty[i / 10] + letters[i % 10];
            }
        }
        return result;
    }
}
