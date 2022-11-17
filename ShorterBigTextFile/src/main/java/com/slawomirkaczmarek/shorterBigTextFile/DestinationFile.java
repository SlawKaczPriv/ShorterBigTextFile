package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class DestinationFile {

	private final Path path;
	private final boolean exists;
	private final FileSize size;
	// Bytes
	private final long sizeBytes;

	/**
	 * 
	 * @param path
	 * @param shorterTextFileSize
	 */
	DestinationFile(Path path, FileSize size) {
		
		this.path = path;
		this.exists = exists(path);
		this.size = size;
		this.sizeBytes = size.bytes();
	}

	private boolean exists(Path path) {
		
		try {
			if(Files.exists(path)) {
				return true;
			}else {
				return false;}
		}catch (SecurityException e) {
			System.out.println("EXCEPTION from SourceFile Files.exists(): " + e.getMessage());
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	boolean exists() {
		return exists;
	}

	/**
	 * 
	 * @return true if success otherwise false
	 * @throws Exception
	 */
	boolean deleteIt() {
		
		try {
			Files.delete(path);
			System.out.println("Deleted ShorterTextFile: " + path);
			return true;
		}catch (Exception e) {
			System.out.println("EXCEPTION from Files.delete(): " + e.getMessage());
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	FileSize size() {
		return size;
	}
}
