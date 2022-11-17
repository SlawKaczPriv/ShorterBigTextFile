package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class MegaByte {

	/** 1_048_476 Bytes */
	public static final int ONE_MEGA_BYTES = (int) Math.pow(2, 20);
	/** 0 */
	public static final long MIN_VALUE = 0;
	/** 8_796_093_022_207 [MB] Mega Bytes */
	public static final long MAX_VALUE = Long.MAX_VALUE / ONE_MEGA_BYTES;
	
	private final double megaByteValue;
	private final long byteValue;

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
			this.byteValue = result * ONE_MEGA_BYTES;
		}
	}

	
	MegaByte(long bytes) throws IllegalArgumentException{
		
		if(bytes < MIN_VALUE) {
			throw new IllegalArgumentException("MegaByte argument value have to be between 0 and " + (MAX_VALUE * ONE_MEGA_BYTES));
		}else if(bytes > MAX_VALUE * ONE_MEGA_BYTES) {
			throw new IllegalArgumentException("MegaByte argument value have to be between 0 and " + (MAX_VALUE * ONE_MEGA_BYTES));
		}else {
			this.megaByteValue = (double) bytes / ONE_MEGA_BYTES;
			this.byteValue = bytes;
		}
	}

	/**
	 * 
	 * @return
	 */
	long getBytes() {
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
		return byteValue == other.byteValue;
	}
	
}
