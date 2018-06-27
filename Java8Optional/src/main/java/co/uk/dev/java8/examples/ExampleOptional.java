package co.uk.dev.java8.examples;

import java.util.Optional;

/**
 * Optional Java a8 Examples
 *
 */
public class ExampleOptional {
	final static String stree = null;

	public static void main(String[] args) {
		System.out.println(stree);
		Optional<String> str = Optional.empty();
		String text = null;
		String defaultText = Optional.ofNullable(text).orElseGet(() -> "Else Get , using Supplier");
		String defaultText1 = Optional.ofNullable(text).orElse("Else only Hello Wrold");
		System.out.println("  Value of --> " + defaultText);
		System.out.println("  Value of --> " + defaultText1);
		System.out.println("------" + (.1 * 3));
		str = Optional.of("Hello");
		System.out.println(str.get());
		Integer a = null;
		Integer b = 10;
		ExampleOptional example = new ExampleOptional();
		// Parameters are passed as an Optional of values.
		int value = example.sum(Optional.ofNullable(a), Optional.of(b));
		System.out.println("Addition  " + value);
		Optional<Integer> c = Optional.ofNullable(100);
		Optional<Integer> d = Optional.ofNullable(90);
		value = example.substract(c, d);
		System.out.println("Substraction " + value);

	}

	public int sum(Optional<Integer> a, Optional<Integer> b) {
		return (a.isPresent() ? a.get() : 0) + (b.isPresent() ? b.get() : 0);
	}

	/**
	 * Substraction
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public int substract(Optional<Integer> a, Optional<Integer> b) {
		return (a.isPresent() ? a.get() : 0) - (b.isPresent() ? b.get() : 0);
	}

}
