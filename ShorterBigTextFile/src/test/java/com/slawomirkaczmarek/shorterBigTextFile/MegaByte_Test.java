package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
			new MegaByte(String.valueOf(MegaByte.MIN_VALUE.getValue().subtract(new BigDecimal(1))));
		});
	}

	@Test
	void megaByte_test_IllegalArgumentException_moreThanMaxValue() throws Exception {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new MegaByte(String.valueOf(MegaByte.MAX_VALUE.getValue().add(new BigDecimal(1))));
		});
	}

	@Test
	void getBytes_test_value_0() throws Exception {
		
		assertEquals(new Byte(0), new MegaByte("0").getBytes());
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
	void getBytes_test_value_1() throws Exception {
		
		assertEquals(new Byte(Byte.ONE_MEGA_BYTES.longVal()), new MegaByte("1").getBytes());
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
	
	@Test
	void test() {
		
		System.out.println("max int=" + Integer.MAX_VALUE);
		
		Byte bytes = new Byte(1234);
		MegaByte test = new MegaByte(bytes);
		System.out.println(test);
		
		System.out.println("ONE_MEGA_BYTES=" + (int) Math.pow(2, 20));
		System.out.println("ONE_MEGA_BYTES=" + Math.pow(2, 20));
		
		double megaByteMaxVal = megaByteMaxVal();
		System.out.println("megaBytaMaxVal=" + megaByteMaxVal);
		long byteMaxVal = (long) (megaByteMaxVal * Byte.ONE_MEGA_BYTES.longVal());
		System.out.println("ByteMaxVal=" + byteMaxVal);
		System.out.println("longMaxVal=" + Long.MAX_VALUE);
	}

	private double megaByteMaxVal() {
		
		BigDecimal longMaxValue = new BigDecimal(Long.MAX_VALUE);
		BigDecimal oneMegaByte = new BigDecimal(Byte.ONE_MEGA_BYTES.longVal());
		
//		BigDecimal resultMaxMB = longMaxValue.divide(oneMegaByte, 6, RoundingMode.DOWN);
		BigDecimal resultMaxMB = longMaxValue.divide(oneMegaByte);
		System.out.println("result maxMegaByte=" + resultMaxMB);
		
		BigDecimal resultMaxB = resultMaxMB.multiply(oneMegaByte);
		System.out.println("result maxByte=" + resultMaxB);
		
		
		return ((long) ((Long.MAX_VALUE / Byte.ONE_MEGA_BYTES.longVal()) * 1_000_000)) / (double) 1_000_000;
	}
}
