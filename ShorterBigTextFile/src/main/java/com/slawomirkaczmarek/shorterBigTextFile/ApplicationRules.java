package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.IOException;
import java.nio.file.Files;

/**
 * 
 */
class ApplicationRules {

	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ApplicationRules() { }

	/**
	 * 
	 * @param bigTextFile 
	 * @param appProperties 
	 * @return
	 */
	static boolean areSatisfied(SourceFile bigTextFile, Arguments appProperties) {
		
		long bigTextFileSize = bigTextFile.getSize();
		
		if(bigTextFileSize < appProperties.megaBytes.getBytes()) {
			System.out.println("Size of new short file is bigger than size of bigTextFile.");
			return false;
		}else if(bigTextFileSize == appProperties.megaBytes.getBytes()) {
			System.out.println("Size of new short file is equals of bigTextFile size.");
			return false;
		}
		
		return true;
	}
}
