package info.monoweb.projecteuler;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Problem0019 {
    public static void main(String[] args) {
        int result = 0;
        LocalDate date = LocalDate.of(1901, 1, 1);
        for (int i = 0, n = 100 * 12; i < n; ++i) {
            if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                ++result;
            }
            date = date.plusMonths(1);
        }
        System.out.println(result);
    }
}
