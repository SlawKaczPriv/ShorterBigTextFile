package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class Bytes implements Comparable<Bytes>{
	
	/** 1_048_476 Bytes */
	public static final Bytes ONE_MEGA_BYTE = new Bytes((int) Math.pow(2, 20));

	private final long value;

	/**
	 * 
	 * @param value
	 */
	Bytes(long value) throws IllegalArgumentException{
		
		if(value < 0) {
			throw new IllegalArgumentException("Value: " + value);
		}else {
			this.value = value;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	long value() {
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
		Bytes other = (Bytes) obj;
		return value == other.value;
	}

	@Override
	public int compareTo(Bytes other) {
		
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
