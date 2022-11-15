package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class FileSize {
	
	/** 1_048_476 Bytes (1 MB) */
	public static final int DEFAULT_SIZE = MegaByte.ONE_MEGA_BYTES;
	
	/** 1 [MB] Mega Bytes */
//	public static final int MIN_MEGA_BYTES = 1;
	
	private final long bytes;
	private final double megaBytes;

	/**
	 * 
	 * @param bytes
	 */
	FileSize(long bytes) {
		
		if(bytes < 0) {
			this.bytes = -1;
			this.megaBytes = -1.0;
		}else {
			this.bytes = bytes;
			this.megaBytes = (double) bytes / MegaByte.ONE_MEGA_BYTES;
		}
	}
	
	FileSize(MegaByte megaBytes) {
		
			this.bytes = megaBytes.getBytes();
			this.megaBytes = (double) bytes / MegaByte.ONE_MEGA_BYTES;
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
