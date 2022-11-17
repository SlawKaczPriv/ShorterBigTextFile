package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class ShorterTextFileRules {
	
//	/** 2047 [MB] Mega Bytes */
//	static final int UPPER_LIMIT = Integer.MAX_VALUE / MegaByte.ONE_MEGA_BYTES;
//	/** 1 [MB] Mega Bytes */
//	static final int LOWER_LIMIT = 1;
	/** 2047 [MB] Mega Bytes */
	static final int UPPER_LIMIT = Integer.MAX_VALUE;
	/** 1 [MB] Mega Bytes */
	static final int LOWER_LIMIT = MegaByte.ONE_MEGA_BYTES;
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ShorterTextFileRules() {}
	
//	static boolean areSatisfied(Arguments appProperties){
	static boolean areSatisfied(DestinationFile destinationTextFile){
		
//		Path path = appProperties.shorterTextFilePath;
		
		if(destinationTextFile.exists()) {
			if(! destinationTextFile.deleteIt()) {
				return false;
			}
		}
		
//		double size = appProperties.shorterTextFileSize.megaBytes();
		int comparing = destinationTextFile.size().compareTo(UPPER_LIMIT);
		if(destinationTextFile.size().compareTo(UPPER_LIMIT) > 0) {
			System.out.println("To big NewShorterTextFile size. Max value:"
					+ UPPER_LIMIT + " Bytes. Requested size: " + destinationTextFile.size().bytes() + " Bytes");
			return false;
		}else if(destinationTextFile.size().compareTo(LOWER_LIMIT) < 0) {
			System.out.println("To small NewShorterTextFile size. Min value: "
					+ LOWER_LIMIT + " MB. Requested size: " + destinationTextFile.size().bytes() + " Bytes");
			return false;
		}
	
		return true;
	}
}
