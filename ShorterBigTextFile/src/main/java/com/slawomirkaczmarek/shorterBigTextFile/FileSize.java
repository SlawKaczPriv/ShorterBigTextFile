package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Objects;

/**
 * 
 */
class FileSize implements Comparable<FileSize>{
	
	private final Bytes bytes;

	/**
	 * 
	 * @param bytes
	 * @throws IllegalArgumentException
	 */
	FileSize(Bytes bytes) {
		this.bytes = bytes;
	}
	
	FileSize(MegaByte megaBytes) {
			this.bytes = megaBytes.getBytes();
	}

	/**
	 * 
	 * @return
	 */
	Bytes bytes() {
		return bytes;
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
		
		if (!(obj instanceof FileSize)) {
			return false;
		}
		
		FileSize other = (FileSize) obj;
		return bytes == other.bytes;
	}

	@Override
	public String toString() {
		return "FileSize [bytes=" + bytes + "]";
	}

	/**
	 * 
	 * @param upperLimit
	 * @return
	 */
	int compareTo(Bytes bytes) {
		return this.bytes.compareTo(bytes);
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	@Override
	public int compareTo(FileSize other) {
		return this.bytes.compareTo(other.bytes);
	}
}
