package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MegaByte_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void megaByte_test_NumberFormatException() throws Exception {
		
		assertThrows(NumberFormatException.class, () -> {
			new MegaByte("bla");
		});
	}

	@Test
	void megaByte_test_IllegalArgumentException_lessThanMinValue() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			new MegaByte(String.valueOf(MegaByte.MIN_VALUE - 1));
		});
	}

	@Test
	void megaByte_test_IllegalArgumentException_moreThanMaxValue() throws Exception {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new MegaByte(String.valueOf(MegaByte.MAX_VALUE + 1));
		});
	}

	@Test
	void getBytes_test_value_0() throws Exception {
		
		assertEquals(new Byte(0), new MegaByte("0").getBytes());
	}

	@Test
	void getBytes_test_maxValue() throws Exception {
		
		// Given
		long expected = MegaByte.MAX_VALUE * Byte.ONE_MEGA_BYTE.value();
		
		// When
		long actual = new MegaByte(String.valueOf(MegaByte.MAX_VALUE)).getBytes().value();
		
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void getBytes_test_minValue() throws Exception {
		
		// Given
		long expected = MegaByte.MIN_VALUE * Byte.ONE_MEGA_BYTE.value();
		
		// When
		long actual = new MegaByte(String.valueOf(MegaByte.MIN_VALUE)).getBytes().value();
		
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void getBytes_test_value_1() throws Exception {
		
		assertEquals(new Byte(Byte.ONE_MEGA_BYTE.value()), new MegaByte("1").getBytes());
	}
	
	@Test
	void maxValue_test() throws Exception {
		
		double max = (double) Long.MAX_VALUE / (int) Math.pow(2, 20);
		long maxVal = (long) (max * 1_000_000);
		double maxValMegaBytes = maxVal / 1_000_000;
		System.out.println("MegaByte maxValue=" + max);
		System.out.println("MegaByte maxValue=" + maxVal);
		System.out.println("MegaByte maxValue=" + maxValMegaBytes);
	}
}
