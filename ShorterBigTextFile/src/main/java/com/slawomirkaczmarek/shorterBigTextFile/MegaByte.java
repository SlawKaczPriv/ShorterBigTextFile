package com.slawomirkaczmarek.shorterBigTextFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 
 */
class MegaByte {
	
	/** 1_048_476 Bytes */
	private static final BigDecimal ONE_MEGA_BYTES = new BigDecimal(Byte.ONE_MEGA_BYTES.longVal());
	
	/** 0 */
	public static final MegaByte MIN_VALUE = new MegaByte(Byte.MIN_VALUE);
	/** 8_796_093_022_207.999_999_046_325_683_593_75 [MB] Mega Bytes */
	public static final MegaByte MAX_VALUE = new MegaByte(Byte.MAX_VALUE);
	
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
		if(result.compareTo(MIN_VALUE.megaBytes) < 0) {
			throw new IllegalArgumentException("String value: " + value);
		}else if(result.compareTo(MAX_VALUE.megaBytes) > 0) {
			throw new IllegalArgumentException("String value: " + value);
		}else {
			this.megaBytes = result;
			this.bytes = bytes(this.megaBytes);
		}
	}

	private Byte bytes(BigDecimal megaBytes) {
		
		long value = megaBytes.multiply(ONE_MEGA_BYTES)
				.setScale(0, RoundingMode.HALF_UP)
				.longValue();
		return new Byte(value);
	}

	/**
	 * 
	 * @param bytes
	 */
	MegaByte(Byte bytes) {
		
		this.megaBytes = megaBytes(bytes);
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
	BigDecimal getValue() {
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
		return "MegaByte [megaBytes=" + megaBytes + ", bytes=" + bytes.longVal() + "]";
	}
}
