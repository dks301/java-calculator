package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final BiFunction<Double, Double, Double> PLUS = (aDouble, aDouble2) -> aDouble + aDouble2;
	private static final BiFunction<Double, Double, Double> MINUS = (aDouble, aDouble2) -> aDouble - aDouble2;
	private static final BiFunction<Double, Double, Double> MULTIPLICATION = (aDouble, aDouble2) -> aDouble * aDouble2;
	private static final BiFunction<Double, Double, Double> DIVISION = (aDouble, aDouble2) -> aDouble / aDouble2;

	private List<String> expression;
	private Map<String, BiFunction<Double, Double, Double>> functions;

	public Calculator(List<String> expression) {
		this.expression = expression;
		functions = new HashMap<>();

		functions.put("+", PLUS);
		functions.put("-", MINUS);
		functions.put("*", MULTIPLICATION);
		functions.put("/", DIVISION);
	}

	public double calculate() {
		double result = Double.parseDouble(this.expression.get(ZERO));

		for (int i = ONE; i < expression.size() - ONE; i = i + TWO) {
			result = patternMatching(result, i);
		}
		return result;
	}

	public double patternMatching(double result, int index) {
		return functions.get(expression.get(index)).apply(result, Double.parseDouble(expression.get(index + ONE)));
	}
}
