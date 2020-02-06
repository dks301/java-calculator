package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtil {
	private static final String SPACE = " ";
	private static final String EMPTY = "";

	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static String inputMathematicalExpression() throws IOException {
		return checkException(bufferedReader.readLine());
	}

	private static String checkException(String input) {
		return "";
	}

	private static String trimSpace(String input) {
		return input.replaceAll(SPACE, EMPTY);
	}

	public static List<String> split(String input) {
		return Stream.of(input.split(SPACE)).collect(Collectors.toList());
	}
}
