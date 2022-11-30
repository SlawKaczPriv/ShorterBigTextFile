package com.slawomirkaczmarek.shorterBigTextFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 
 */
class MegaByte {
	
	/** 0 */
	public static final long MIN_VALUE = 0;
	/** 8_796_093_022_207 [MB] Mega Bytes */
//	public static final double MAX_VALUE = (double) Long.MAX_VALUE / Byte.ONE_MEGA_BYTE.longVal();
	
	/** 1_048_476 Bytes */
	private static final BigDecimal ONE_MEGA_BYTES = new BigDecimal(Byte.ONE_MEGA_BYTES.longVal());
	
	/** 8_796_093_022_207.999_999_046_325_683_593_75 */
	public static final MegaByte MAX_VALUE = new MegaByte(Byte.MAX_VALUE);
//	private static final BigDecimal MAX_MEGA_BYTE = maxMegaByte();
//	private final double megaBytes;
	private final BigDecimal megaBytes;
	private final Byte bytes;

	/**
	 * 
	 * @param value
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 */
	MegaByte(String value) throws NumberFormatException, IllegalArgumentException {
		
		BigDecimal result = new BigDecimal(value);
		if(result.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("String value: " + value);
		}else if(result.compareTo(MAX_VALUE.megaBytes) > 0) {
			throw new IllegalArgumentException("String value: " + value);
		}else {
			this.megaBytes = result;
			this.bytes = new Byte(result.multiply(ONE_MEGA_BYTES).setScale(0, RoundingMode.HALF_UP).longValue());
		}
		
//		if(allowedNuberOfDecimalPlacesForMegaByte(result.doubleValue())) {
//			this.megaBytes = result.doubleValue();
//			this.bytes = new Byte((int) (result.doubleValue() * Byte.ONE_MEGA_BYTES.longVal()));
//		}else {
//			throw new IllegalArgumentException("not allowedNuberOfDecimalPlacesForMegaByte, String value: " + value);
//		}
	}

//	private static BigDecimal maxMegaByte() {
//		
//		BigDecimal longMaxValue = new BigDecimal(Long.MAX_VALUE);
//		return longMaxValue.divide(ONE_MEGA_BYTES);
//	}

//	private boolean allowedNuberOfDecimalPlacesForMegaByte(double megaByte) {
//		return allowedNuberOfDecimalPlaces(megaByte, 1_000_000);
//	}
//
//	private boolean allowedNuberOfDecimalPlaces(double testedNumber, int maxDecimalPlaces) {
//		
//		testedNumber = testedNumber * maxDecimalPlaces;
//		return testedNumber == (int) testedNumber;
//	}

	/**
	 * 
	 * @param bytes
	 */
	MegaByte(Byte bytes) {
		
		this.megaBytes = megaBytes(bytes);//(double) bytes.longVal() / Byte.ONE_MEGA_BYTES.longVal();
		this.bytes = bytes;
	}

	private BigDecimal megaBytes(Byte bytes) {
		
		BigDecimal temp = new BigDecimal(bytes.longVal());
		return temp.divide(ONE_MEGA_BYTES);
	}

	/**
	 * 
	 * @return
	 */
	Byte getBytes() {
		return bytes;
	}
	
	/**
	 * 
	 * @return
	 */
	double getValue() {
		return megaBytes;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(bytes);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MegaByte other = (MegaByte) obj;
		return this.bytes.equals(other.bytes);
	}

	@Override
	public String toString() {
		return "MegaByte [megaByteValue=" + megaBytes + ", byteValue=" + bytes.longVal() + "]";
	}
}
