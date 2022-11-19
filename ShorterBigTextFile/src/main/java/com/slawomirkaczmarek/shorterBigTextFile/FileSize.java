package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class FileSize {
	
	/** 1_048_476 Bytes (1 MB) */
	public static final int DEFAULT_SIZE = MegaByte.ONE_MEGA_BYTES;
	
	private final long bytes;
//	private final double megaBytes;
	private final MegaByte megaBytes;

	/**
	 * 
	 * @param bytes
	 * @throws IllegalArgumentException
	 */
	FileSize(long bytes) throws IllegalArgumentException {
		
		if(bytes < 0) {
			throw new IllegalArgumentException("FileSize argument value have to positive number or 0.");
		}else {
			this.bytes = bytes;
//			this.megaBytes = (double) bytes / MegaByte.ONE_MEGA_BYTES;
			this.megaBytes = new MegaByte(bytes);
		}
	}
	
	FileSize(MegaByte megaBytes) {
		
			this.bytes = megaBytes.getBytes();
//			this.megaBytes = (double) bytes / MegaByte.ONE_MEGA_BYTES;
			this.megaBytes = megaBytes;
	}

	/**
	 * 
	 * @return
	 */
	double megaBytes() {
		return megaBytes.getValue();
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
		return bytes == other.bytes;// &&
//				Double.doubleToLongBits(megaBytes) == Double.doubleToLongBits(other.megaBytes);
	}

	@Override
	public String toString() {
		return "FileSize [bytes=" + bytes + ", megaBytes=" + megaBytes + "]";
	}

	/**
	 * 
	 * @param upperLimit
	 * @return
	 */
	int compareTo(int bytesToCompare) {
		
		if(this.bytes < bytesToCompare) {
			return -1;
		}else if(this.bytes > bytesToCompare) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	int compareTo(FileSize other) {
		
		if(this.bytes < other.bytes) {
			return -1;
		}else if(this.bytes > other.bytes) {
			return 1;
		}else {
			return 0;
		}
	}
}
