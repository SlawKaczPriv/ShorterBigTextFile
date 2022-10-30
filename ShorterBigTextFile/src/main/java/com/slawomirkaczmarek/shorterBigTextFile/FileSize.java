package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class FileSize {

	public static final int ONE_MEGA_BYTES = (int) Math.pow(2, 20);
	public static final int DEFAULT_SIZE = ONE_MEGA_BYTES;
	
	private final int bytes;
	private final double megaBytes;

	/**
	 * 
	 * @param bytes
	 */
	FileSize(int bytes) {
		
		this.bytes = bytes;
		this.megaBytes = bytes / ONE_MEGA_BYTES;
	}

	/**
	 * 
	 * @return
	 */
	double megaBytes() {
		return megaBytes;
	}

	/**
	 * 
	 * @return
	 */
	int bytes() {
		return bytes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bytes, megaBytes);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof FileSize)) {
			return false;
		}
		
		FileSize other = (FileSize) obj;
		return bytes == other.bytes &&
				Double.doubleToLongBits(megaBytes) == Double.doubleToLongBits(other.megaBytes);
	}

	@Override
	public String toString() {
		return "FileSize [bytes=" + bytes + ", megaBytes=" + megaBytes + "]";
	}
}
