package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ByteTest {

	@Test
	void testHashCode() throws Exception {
		
		Byte byte1 = new Byte(0);
		Byte byte2 = new Byte(0);
		Byte byte3 = new Byte(1);
		
		assertTrue(byte1.hashCode() == byte2.hashCode());
		assertTrue(byte2.hashCode() != byte3.hashCode());
	}

	@Test
	void byte_test_illegalArgumentException() throws Exception {

		assertThrows(IllegalArgumentException.class, () -> {
			new Byte(-1);
		});
	}

	@Test
	void value_test() throws Exception {
		
		Byte byte1 = new Byte(0);
		
		assertEquals(0, byte1.longVal());
	}

	@Test
	void equals_test() throws Exception {
		
		Byte byte1 = new Byte(0);
		Byte byte2 = new Byte(0);
		Byte byte3 = new Byte(1);
		
		assertTrue(byte1.equals(byte2));
		assertFalse(byte1.equals(byte3));
	}

	@Test
	void compareTo_test() throws Exception {
		
		Byte byte1 = new Byte(0);
		Byte byte2 = new Byte(0);
		Byte byte3 = new Byte(1);
		
		assertEquals(0, byte1.compareTo(byte2));
		assertTrue(byte2.compareTo(byte3) < 0);
		assertTrue(byte3.compareTo(byte2) > 0);
	}
}
