package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
	private static final int FIRST_NUMBER = 0;
	private static final Map<String, BiFunction<Double, Double, Double>> functions = new HashMap<>();

	static {
		functions.put("+", (aDouble, aDouble2) -> aDouble + aDouble2);
		functions.put("-", (aDouble, aDouble2) -> aDouble - aDouble2);
		functions.put("*", (aDouble, aDouble2) -> aDouble * aDouble2);
		functions.put("/", (aDouble, aDouble2) -> aDouble / aDouble2);
	}

	private List<String> expression;

	public Calculator(List<String> expression) {
		this.expression = expression;
	}

	public double calculate() {
		double result = Double.parseDouble(this.expression.get(FIRST_NUMBER));

		for (int i = 1; i < expression.size(); i = i + 2) {
			result = patternMatching(result, i);
		}
		return result;
	}

	public double patternMatching(double result, int index) {
		return functions.get(expression.get(index)).apply(result, Double.parseDouble(expression.get(index + 1)));
	}
}
