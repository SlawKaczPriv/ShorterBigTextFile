package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class DestinationFile extends File {
	
	/**
	 * 
	 * @param path
	 * @param shorterTextFileSize
	 */
	DestinationFile(Path path, Byte size) {
		
		super(path);
		this.size = size;
	}

	/**
	 * 
	 * @return true if success otherwise false
	 * @throws Exception
	 */
	boolean delete() {
		
		try {
			Files.delete(path);
			// System.out.println("INFO. Deleted ShorterTextFile: " + path);
			return true;
		}catch (Exception e) {
			System.out.println("EXCEPTION from Files.delete(): " + e.getMessage());
			return false;
		}
	}
}
