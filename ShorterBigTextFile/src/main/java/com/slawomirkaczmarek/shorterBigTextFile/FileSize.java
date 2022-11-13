package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class FileSize {

	/** 1_048_476 Bytes (1 MB) */
	public static final int ONE_MEGA_BYTES = (int) Math.pow(2, 20);
	
	/** 1_048_476 Bytes (1 MB) */
	public static final int DEFAULT_SIZE = ONE_MEGA_BYTES;
	
	/** 2047 [MB] Mega Bytes */
	public static final int MAX_MEGA_BYTES = Integer.MAX_VALUE / ONE_MEGA_BYTES;
	
	/** 1 [MB] Mega Bytes */
	public static final int MIN_MEGA_BYTES = 1;
	
	private final long bytes;
	private final double megaBytes;

	/**
	 * 
	 * @param bytes
	 */
	FileSize(long bytes) {
		
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
	long bytes() {
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
