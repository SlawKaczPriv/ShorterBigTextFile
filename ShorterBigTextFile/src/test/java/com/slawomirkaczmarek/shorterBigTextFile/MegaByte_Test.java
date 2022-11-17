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
		
		assertEquals(0, new MegaByte("0").getBytes());
	}

	@Test
	void getBytes_test_maxValue() throws Exception {
		
		// Given
		long expected = MegaByte.MAX_VALUE * MegaByte.ONE_MEGA_BYTES;
		
		// When
		long actual = new MegaByte(String.valueOf(MegaByte.MAX_VALUE)).getBytes();
		
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void getBytes_test_minValue() throws Exception {
		
		// Given
		long expected = MegaByte.MIN_VALUE * MegaByte.ONE_MEGA_BYTES;
		
		// When
		long actual = new MegaByte(String.valueOf(MegaByte.MIN_VALUE)).getBytes();
		
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void getBytes_test_value_1() throws Exception {
		
		assertEquals(MegaByte.ONE_MEGA_BYTES, new MegaByte("1").getBytes());
	}
}
