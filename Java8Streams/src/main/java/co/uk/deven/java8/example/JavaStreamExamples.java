package co.uk.deven.java8.example;

import java.util.HashMap;
import java.util.Map;

public class JavaStreamExamples {
	public static void main(String[] args) {
		JavaStreamExamples example = new JavaStreamExamples();
		example.variousSamples();

		Map<String, String> map = new HashMap<>();
		map.put("C", "c");
		map.put("B", "b");
		map.merge("B", "NEW", (v1, v2) -> v1 + v2);
		System.out.println(map.get("B")); // prints bNEW

		map.merge("B", "-->HELLO", (t, u) -> t + u);
		System.out.println(map.get("B"));
	}

	public void variousSamples() {

	}
}
