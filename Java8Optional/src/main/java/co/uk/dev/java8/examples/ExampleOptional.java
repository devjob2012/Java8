package co.uk.dev.java8.examples;

import java.util.Optional;

/**
 * Optional Java a8 Examples
 *
 */
public class ExampleOptional {
	public static void main(String[] args) {
		Integer a = null;
		Integer b = 10;
		ExampleOptional example = new ExampleOptional();
		// Parameters are passed as an Optional of values.
		int value = example.sum(Optional.ofNullable(a), Optional.of(b));
		System.out.println("Hello World! " + value);
	}

	/**
	 * Using Optional
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int sum(Optional<Integer> a, Optional<Integer> b) {
		return (a.isPresent() ? a.get() : 0) + (b.isPresent() ? b.get() : 0);
	}
}
