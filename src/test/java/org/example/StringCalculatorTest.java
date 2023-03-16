package org.example;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private final StringCalculator stringCalculator = new StringCalculator();

	@DisplayName("null 이 들어왔을 때 0을 리턴")
	@Test
	void givenNull_whenCalculate_thenReturnsZero() {
		// given
		int expected = 0;

		// when
		int result = StringCalculator.splitAndSum(null);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("blank 가 들어왔을 때 0을 리턴")
	@Test
	void givenBlank_whenCalculate_thenReturnsZero() {
		// given

		// when

		// then
	}
}