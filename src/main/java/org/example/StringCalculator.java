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
		if (input == null || input.isBlank()) {
			return 0;
		}
		String[] values = input.split("[,:]");
		return sum(values);
	}

	private static int sum(String[] values) {
		int result = 0;
		for (String value : values) {
			result += Integer.parseInt(value);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(splitAndSum(br.readLine()));
	}
}