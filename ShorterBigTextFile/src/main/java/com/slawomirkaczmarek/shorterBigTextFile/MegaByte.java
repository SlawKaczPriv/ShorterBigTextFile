package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class MegaByte {
	
	/** 0 */
	public static final long MIN_VALUE = 0;
	/** 8_796_093_022_207 [MB] Mega Bytes */
	public static final long MAX_VALUE = Long.MAX_VALUE / Bytes.ONE_MEGA_BYTE.value();
	
	private final double megaByteValue;
	private final Bytes byteValue;

	/**
	 * 
	 * @param string
	 */
	MegaByte(String string) throws NumberFormatException, IllegalArgumentException{
		
		long result = Long.parseLong(string); // Can throw NumberFormatException
		
		if(result < MIN_VALUE) {
			throw new IllegalArgumentException("MegaByte argument value have to be between 0 and " + MAX_VALUE);
		}else if(result > MAX_VALUE) {
			throw new IllegalArgumentException("MegaByte argument value have to be between 0 and " + MAX_VALUE);
		}else {
			this.megaByteValue = result;
			this.byteValue = new Bytes(result * Bytes.ONE_MEGA_BYTE.value());
		}
	}

	
	MegaByte(Bytes bytes) {
		
		this.megaByteValue = (double) bytes.value() / Bytes.ONE_MEGA_BYTE.value();
		this.byteValue = bytes;
	}

	/**
	 * 
	 * @return
	 */
	Bytes getBytes() {
		return byteValue;
	}
	
	/**
	 * 
	 * @return
	 */
	double getValue() {
		return megaByteValue;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(byteValue);
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
		return this.byteValue.equals(other.byteValue);
	}

	@Override
	public String toString() {
		return "MegaByte [megaByteValue=" + megaByteValue + ", byteValue=" + byteValue.value() + "]";
	}
}
