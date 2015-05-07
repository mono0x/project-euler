package info.monoweb.projecteuler;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

public class Problem0039 {
	@AllArgsConstructor
	static class Data {
		int p;
		long count;
	}
	public static void main(String[] args) {
		final int max = 1000;
		final int result = IntStream.rangeClosed(3, max).mapToObj(p -> {
			final long count = IntStream.range(1, p / 2).filter(c -> {
				final int lhs = p - c;
				return IntStream.range(1, lhs).anyMatch(a -> {
					final int b = lhs - a;
					return a * a + b * b == c * c;
				});
			}).count();
			return new Data(p, count);
		}).max((lhs, rhs) -> Long.compare(lhs.count, rhs.count)).get().p;
		System.out.println(result);
	}
}
