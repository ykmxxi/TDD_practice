package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 https://www.youtube.com/watch?v=bIeqAlmNRrA&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC
 * 문자열 덧셈기
 * - null or blank: 0
 * - [1]: 1
 * - [1, 2]: 3
 * - [1, 2:3]: 6
 * 숫자 이외의 값, 음수인 경우 RuntimeException
 */
public class StringCalculator {

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return 0;
		}
		return sum(toInts(split(input)));
	}

	private static boolean isBlank(String input) {
		return input == null || input.isBlank();
	}

	private static String[] split(String input) {
		return input.split("[,:]");
	}

	private static int[] toInts(String[] values) {
		int[] numbers = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			numbers[i] = Integer.parseInt(values[i]);
		}
		return numbers;
	}

	private static int sum(int[] numbers) {
		int result = 0;
		for (int number : numbers) {
			result += number;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(splitAndSum(br.readLine()));
	}
}