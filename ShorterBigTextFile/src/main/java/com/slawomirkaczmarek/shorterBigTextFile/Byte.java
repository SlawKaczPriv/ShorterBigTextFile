package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class Byte implements Comparable<Byte>{
	
	/** 1_048_476 Bytes */
	public static final Byte ONE_MEGA_BYTES = new Byte((int) Math.pow(2, 20));

	public static final Byte MAX_VALUE = new Byte(Long.MAX_VALUE);

	private final long value;

	/**
	 * 
	 * @param value
	 */
	Byte(long value) throws IllegalArgumentException{
		
		if(value < 0) {
			throw new IllegalArgumentException("long value: " + value);
		}else {
			this.value = value;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	long longVal() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
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
		Byte other = (Byte) obj;
		return value == other.value;
	}

	@Override
	public int compareTo(Byte other) {
		
		if(this.value < other.value) {
			return -1;
		}else if(this.value > other.value) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Bytes [value=" + value + "]";
	}
}
