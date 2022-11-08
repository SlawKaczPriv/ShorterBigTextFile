package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.IOException;
import java.nio.file.Files;

/**
 * 
 */
class ApplicationRules {

	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ApplicationRules() {}

	/**
	 * 
	 * @param appProperties 
	 * @return
	 */
	static boolean areSatisfied(AppProperties appProperties) {
		
		long bigTextFileSize = 0;
		
		try {
			bigTextFileSize = Files.size(appProperties.bigTextFilePath);
		} catch (IOException e) {
			System.out.println("EXCEPTION from Files.size(): " + e.getMessage());
			return false;
		}
		
		if(appProperties.newShorterTextFileSize.bytes() >= bigTextFileSize) {
			System.out.println("Size of new file is bigger than size of bigTextFile.");
			return false;
		}
		
		return true;
	}
}
