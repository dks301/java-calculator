package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
	private static final int FIRST_NUMBER = 0;
	private static final int ODD_INDEX = 1;
	private static final Map<String, BiFunction<Double, Double, Double>> functions = new HashMap<>();

	static {
		functions.put("+", (aDouble, aDouble2) -> aDouble + aDouble2);
		functions.put("-", (aDouble, aDouble2) -> aDouble - aDouble2);
		functions.put("*", (aDouble, aDouble2) -> aDouble * aDouble2);
		functions.put("/", (aDouble, aDouble2) -> aDouble / aDouble2);
	}

	private List<String> numbers;
	private List<String> operators;

	public Calculator(List<String> expression) {
		numbers = new ArrayList<>();
		operators = new ArrayList<>();

		for (int i = 0; i < expression.size(); i++) {
			if (i % 2 == ODD_INDEX) {
				operators.add(expression.get(i));
				continue;
			}
			numbers.add(expression.get(i));
		}
	}

	public double calculate() {
		double result = Double.parseDouble(this.numbers.remove(FIRST_NUMBER));

		for (int i = 0; i < operators.size(); i++) {
			result = calculateByFunctions(result, i);
		}
		return result;
	}

	public double calculateByFunctions(double result, int index) {
		return functions.get(operators.get(index)).apply(result, Double.parseDouble(numbers.get(index)));
	}
}
