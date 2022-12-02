package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class MegaByte_Test {

	@Test
	void MegaByte_test_NumberFormatException() throws Exception {
		
		assertThrows(NumberFormatException.class, () -> {
			new MegaByte("bla");
		});
	}

	@Test
	void MegaByte_test_IllegalArgumentException_lessThanMinValue() throws Exception {
		
		// Given
		BigDecimal lessThanMegaByteMinValue = MegaByte.MIN_VALUE.getValue().subtract(new BigDecimal(0.000_000_000_000_000_000_001));
		
		// Then
		assertThrows(IllegalArgumentException.class, () -> {
			new MegaByte(String.valueOf(lessThanMegaByteMinValue));
		});
	}

	@Test
	void MegaByte_test_IllegalArgumentException_moreThanMaxValue() throws Exception {
		
		// Given
		BigDecimal moreThanMegaByteMaxValue = MegaByte.MAX_VALUE.getValue().add(new BigDecimal(0.000_000_000_000_000_000_001));
		
		// Then
		assertThrows(IllegalArgumentException.class, () -> {
			new MegaByte(String.valueOf(moreThanMegaByteMaxValue));
		});
	}

	@Test
	void getBytes_tests() throws Exception {
		
		assertEquals(new Byte(0), new MegaByte("0").getBytes());
		assertEquals(Byte.ONE_MEGA_BYTES, new MegaByte("1").getBytes());
	}

	@Test
	void getBytes_test_maxValue() throws Exception {
		
		// Given
		Byte expected = Byte.MAX_VALUE;
				
		// When
		Byte actual = MegaByte.MAX_VALUE.getBytes(); 
		
		// Then
		assertEquals(expected, actual);
	}

	@Test
	void getBytes_test_minValue() throws Exception {
		
		// Given
		Byte expected = Byte.MIN_VALUE;
		
		// When
		Byte actual = MegaByte.MIN_VALUE.getBytes(); 
		
		// Then
		assertEquals(expected, actual);
	}
	
	@Test
	void getValue_tests() throws Exception {
		
		// Given
		MegaByte given1 = new MegaByte(Byte.ONE_MEGA_BYTES);
		MegaByte given2 = new MegaByte(Byte.MIN_VALUE);
		MegaByte given3 = new MegaByte(Byte.MAX_VALUE);
		
		// Then
		assertEquals(new BigDecimal("1"), given1.getValue());
		assertEquals(new BigDecimal("0"), given2.getValue());
		assertEquals(new BigDecimal("8796093022207.99999904632568359375"), given3.getValue());
	}
	
	@Test
	void equals_tests() throws Exception {
		
		// Given
		MegaByte given1a = new MegaByte(Byte.ONE_MEGA_BYTES);
		MegaByte given1b = new MegaByte("1");
				
		MegaByte given2a = new MegaByte(Byte.MIN_VALUE);
		MegaByte given2b = MegaByte.MIN_VALUE;
		MegaByte given2c = new MegaByte("0");
				
		MegaByte given3a = new MegaByte(Byte.MAX_VALUE);
		MegaByte given3b = MegaByte.MAX_VALUE;
		MegaByte given3c = new MegaByte("8796093022207.99999904632568359375");
		
		
		// Then
		assertTrue(given1a.equals(given1b));
		
		assertTrue(given2a.equals(given2b));
		assertTrue(given2a.equals(given2c));
		
		assertTrue(given3a.equals(given3b));
		assertTrue(given3a.equals(given3c));
	}
	
	@Test
	void hashCode_tests() throws Exception {
		
		// Given
		MegaByte given1a = new MegaByte(Byte.ONE_MEGA_BYTES);
		MegaByte given1b = new MegaByte("1");
		
		MegaByte given2a = new MegaByte(Byte.MIN_VALUE);
		MegaByte given2b = MegaByte.MIN_VALUE;
		MegaByte given2c = new MegaByte("0");
		
		MegaByte given3a = new MegaByte(Byte.MAX_VALUE);
		MegaByte given3b = MegaByte.MAX_VALUE;
		MegaByte given3c = new MegaByte("8796093022207.99999904632568359375");
		
		
		// Then
		assertTrue(given1a.hashCode() == given1b.hashCode());
		
		assertTrue(given2a.hashCode() == given2b.hashCode());
		assertEquals(given2a.hashCode(), given2c.hashCode());
		
		assertTrue(given3a.hashCode() == given3b.hashCode());
		assertEquals(given3a.hashCode(), given3c.hashCode());
	}
	
//	@Test
//	void maxValue_test() throws Exception {
//		
//		double max = (double) Long.MAX_VALUE / (int) Math.pow(2, 20);
//		long maxVal = (long) (max * 1_000_000);
//		double maxValMegaBytes = maxVal / 1_000_000;
//		System.out.println("MegaByte maxValue=" + max);
//		System.out.println("MegaByte maxValue=" + maxVal);
//		System.out.println("MegaByte maxValue=" + maxValMegaBytes);
//	}
//	
//	@Test
//	void test() {
//		
//		System.out.println("max int=" + Integer.MAX_VALUE);
//		
//		Byte bytes = new Byte(1234);
//		MegaByte test = new MegaByte(bytes);
//		System.out.println(test);
//		
//		System.out.println("ONE_MEGA_BYTES=" + (int) Math.pow(2, 20));
//		System.out.println("ONE_MEGA_BYTES=" + Math.pow(2, 20));
//		
//		double megaByteMaxVal = megaByteMaxVal();
//		System.out.println("megaBytaMaxVal=" + megaByteMaxVal);
//		long byteMaxVal = (long) (megaByteMaxVal * Byte.ONE_MEGA_BYTES.longVal());
//		System.out.println("ByteMaxVal=" + byteMaxVal);
//		System.out.println("longMaxVal=" + Long.MAX_VALUE);
//	}
//
//	private double megaByteMaxVal() {
//		
//		BigDecimal longMaxValue = new BigDecimal(Long.MAX_VALUE);
//		BigDecimal oneMegaByte = new BigDecimal(Byte.ONE_MEGA_BYTES.longVal());
//		
////		BigDecimal resultMaxMB = longMaxValue.divide(oneMegaByte, 6, RoundingMode.DOWN);
//		BigDecimal resultMaxMB = longMaxValue.divide(oneMegaByte);
//		System.out.println("result maxMegaByte=" + resultMaxMB);
//		
//		BigDecimal resultMaxB = resultMaxMB.multiply(oneMegaByte);
//		System.out.println("result maxByte=" + resultMaxB);
//		
//		
//		return ((long) ((Long.MAX_VALUE / Byte.ONE_MEGA_BYTES.longVal()) * 1_000_000)) / (double) 1_000_000;
//	}
}
