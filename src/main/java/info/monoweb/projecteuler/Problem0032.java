package info.monoweb.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem0032 {
	public static void main(String[] args) {

		final List<Integer> numbers = new ArrayList<>();
		final Set<Integer> result = next(numbers);
		System.out.println(result.stream().mapToInt(i -> i).sum());
	}

	static Set<Integer> next(List<Integer> numbers) {
		if (numbers.size() == 9) {
			return IntStream.rangeClosed(1, 4).flatMap(i ->
				IntStream.rangeClosed(1, 6 - i).mapToObj(j ->
					new int[] {
							numbersToValue(numbers.stream().limit(i)),
							numbersToValue(numbers.stream().skip(i).limit(j)),
							numbersToValue(numbers.stream().skip(i + j)),
					}).filter(ar -> ar[0] >= ar[1]).filter(ar -> ar[0] * ar[1] == ar[2]).mapToInt(ar -> ar[2])
			).mapToObj(Integer::valueOf).collect(Collectors.toSet());
		}
		return IntStream.rangeClosed(1, 9).mapToObj(i -> {
			if (!numbers.contains(i)) {
				numbers.add(i);
				try {
					return next(numbers);
				} finally {
					numbers.removeIf(n -> n == i);
				}
			}
			return Collections.<Integer>emptySet();
		}).reduce(Collections.<Integer>emptySet(), (l, r) -> {
				final Set<Integer> set = new HashSet<Integer>(l);
				set.addAll(r);
				return set;
			});
	}

	static int numbersToValue(Stream<Integer> numbers) {
		return numbers.reduce(0, (l, r) -> l * 10 + r);
	}

}
