package org.example;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {

	@DisplayName("null 이 들어왔을 때 0을 리턴")
	@Test
	void givenNull_whenSplitAndSum_thenReturnsZero() {
		// given

		// when & then
		assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
	}

	@DisplayName("blank 가 들어왔을 때 0을 리턴")
	@Test
	void givenBlank_whenSplitAndSum_thenReturnsZero() {
		// given

		// when & then
		assertThat(StringCalculator.splitAndSum("   ")).isEqualTo(0);
	}

	@DisplayName("값이 한개 일 때 자기 자신을 리턴")
	@ParameterizedTest(name = "[{index}] \"{0}\" 이 입력되면 {1}을 리턴")
	@MethodSource()
	void givenOneString_whenSplitAndSum_thenReturnsSelf(String input, int expected) {
		// given

		// when & then
		assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
	}

	static Stream<Arguments> givenOneString_whenSplitAndSum_thenReturnsSelf() {
		return Stream.of(
			arguments("1", 1),
			arguments("2", 2),
			arguments("3", 3),
			arguments("4", 4),
			arguments("5", 5),
			arguments("6", 6),
			arguments("7", 7),
			arguments("8", 8),
			arguments("9", 9)
		);
	}

	@DisplayName("쉼표로만 구분된 숫자들이 주어졌을 때 더한 값을 리턴")
	@ParameterizedTest(name = "[{index}] \"{0}\" 이 입력되면 {1}을 리턴")
	@MethodSource
	void givenStringWithComma_whenSplitAndSum_thenReturnsSumResult(String input, int expected) {
		// given

		// when & then
		assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
	}

	static Stream<Arguments> givenStringWithComma_whenSplitAndSum_thenReturnsSumResult() {
		return Stream.of(
			arguments("1,2", 3),
			arguments("3,4", 7),
			arguments("5,6", 11),
			arguments("11,22", 33),
			arguments("333,222", 555)
		);
	}

	@DisplayName("쉼표와 콜론으로 구분된 숫자들이 주어졌을 때 더한 값을 리턴")
	@ParameterizedTest(name = "[{index}] \"{0}\" 이 입력되면 {1}을 리턴")
	@MethodSource
	void givenStringWithCommaAndColon_whenSplitAndSum_thenReturnsSumResult(String input, int expected) {
		// given

		// when & then
		assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
	}

	static Stream<Arguments> givenStringWithCommaAndColon_whenSplitAndSum_thenReturnsSumResult() {
		return Stream.of(
			arguments("1,2:3", 6),
			arguments("3:4,5", 12),
			arguments("6:7:8", 21),
			arguments("11,22,33", 66),
			arguments("1:2,3:4,5", 15)
		);
	}

	@DisplayName("잘못된 값이 주어졌을 때 RuntimeException 을 던지기")
	@ParameterizedTest(name = "[{index}] \"{0}\" 이 입력되면 {1}을 리턴")
	@MethodSource
	void givenWrongInput_whenSplitAndSum_thenThrowRuntimeException(String input) {
		// given

		// when & then
		assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
			.isInstanceOf(RuntimeException.class);
	}

	static Stream<Arguments> givenWrongInput_whenSplitAndSum_thenThrowRuntimeException() {
		return Stream.of(
			arguments("-1,2:3"),
			arguments("3:사,5"),
			arguments("6:-122:8"),
			arguments("-11,22,33"),
			arguments("!1:2,3:4,5"),
			arguments("6:twelve:8"),
			arguments("6.8")
		);
	}
}