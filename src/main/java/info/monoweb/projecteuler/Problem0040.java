package info.monoweb.projecteuler;

public class Problem0040 {
	public static void main(String[] args) {
		final int n = 1_000_000;
		final StringBuilder sb = new StringBuilder();
		for (int i = 1; sb.length() < n; ++i) {
			sb.append(i);
		}
		final String s = sb.toString();

		int product = 1;
		for (int i = 1; i <= n; i *= 10) {
			product *= s.charAt(i - 1) - '0';
		}
		System.out.println(product);
	}
}
