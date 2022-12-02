package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Byte_Test {

	@Test
	void byte_test_illegalArgumentException() throws Exception {

		assertThrows(IllegalArgumentException.class, () -> {
			new Byte(-1);
		});
	}

	@Test
	void longVal_test() throws Exception {
		
		// Given
		Byte bytee = new Byte(0);
		
		// Then
		assertEquals(0, bytee.longVal());
	}

	@Test
	void hashCode_tests() throws Exception {
		
		// Given
		Byte byte1 = new Byte(0);
		Byte byte2 = new Byte(0);
		Byte byte3 = new Byte(1);
		
		// Then
		assertTrue(byte1.hashCode() == byte2.hashCode());
		assertTrue(byte2.hashCode() != byte3.hashCode());
	}

	@Test
	void equals_tests() throws Exception {
		
		// Given
		Byte byte1 = new Byte(0);
		Byte byte2 = new Byte(0);
		Byte byte3 = new Byte(1);
		
		// Then
		assertTrue(byte1.equals(byte2));
		assertFalse(byte1.equals(byte3));
	}

	@Test
	void compareTo_tests() throws Exception {
		
		// Given
		Byte byte1 = new Byte(Long.MAX_VALUE - 1);
		Byte byte2 = new Byte(Long.MAX_VALUE - 1);
		Byte byte3 = new Byte(Long.MAX_VALUE);
		
		// Then
		assertEquals(0, byte1.compareTo(byte2));
		assertTrue(byte2.compareTo(byte3) < 0);
		assertTrue(byte3.compareTo(byte2) > 0);
	}
}
