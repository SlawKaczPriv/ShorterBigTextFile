package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class MegaByte {
	
	/** 0 */
	public static final long MIN_VALUE = 0;
	/** 8_796_093_022_207 [MB] Mega Bytes */
	public static final long MAX_VALUE = Long.MAX_VALUE / Byte.ONE_MEGA_BYTE.value();
	
	private final double megaBytes;
	private final Byte bytes;

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
			this.megaBytes = result;
			this.bytes = new Byte(result * Byte.ONE_MEGA_BYTE.value());
		}
	}

	
	MegaByte(Byte bytes) {
		
		this.megaBytes = (double) bytes.value() / Byte.ONE_MEGA_BYTE.value();
		this.bytes = bytes;
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
		return "MegaByte [megaByteValue=" + megaBytes + ", byteValue=" + bytes.value() + "]";
	}
}
