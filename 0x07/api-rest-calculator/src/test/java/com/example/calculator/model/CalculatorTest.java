package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	void sumTest() {
		// when
		double sum = calculator.sum(22d, 50d);
		// then
		assertEquals(72d, sum);
	}

	@Test
	public void numbersNullSumTest() {
		// when
		Exception exception = assertThrows(NullPointerException.class, () -> {
			calculator.sum(null, 50d);
		});

		// then
		assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
	}

	@Test
	void subTest() {
		// when
		double sub = calculator.sub(58d, 13d);
		// then
		assertEquals(45d, sub);
	}

	@Test
	void divideTest() {
		// when
		double result = calculator.divide(50d, 2d);
		// then
		assertEquals(25d, result);
	}

	@Test
	public void divisionByZeroTest() {
		// when
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			calculator.divide(100d, 0d);
		});

		// then
		assertEquals("Divisão por zero não é permitido.", exception.getMessage());
	}

	@Test
	void factorialTest() {
		// when
		int result = calculator.factorial(6);
		// then
		assertEquals(720, result);
	}

	@Test
	void integerToBinaryTest() {
		// when
		int bin = calculator.integerToBinary(256); // 1111111
		// then
		assertEquals(100000000, bin);
	}

	@Test
	void integerToHexadecimalTest() {
		// when
		String hex = calculator.integerToHexadecimal(256);
		// then
		assertEquals("100", hex);
	}

	@Test
	void calculeDayBetweenDateTest() {
		// when
		int days = calculator.calculeDayBetweenDate(LocalDate.of(2020, 3, 15), LocalDate.of(2020, 3, 29));
		// then
		assertEquals(14, days);
	}

}
