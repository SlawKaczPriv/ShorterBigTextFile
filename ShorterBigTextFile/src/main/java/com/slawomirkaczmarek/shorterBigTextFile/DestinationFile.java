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
	DestinationFile(Path path, FileSize fileSize) {
		
		super(path);
		this.fileSize = fileSize;
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
}
