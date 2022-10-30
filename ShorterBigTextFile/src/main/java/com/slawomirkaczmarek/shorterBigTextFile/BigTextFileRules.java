package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class BigTextFileRules {
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private BigTextFileRules() { }

	/**
	 * 
	 * @param bigTextFilePath
	 * @return
	 */
	static boolean areSatisfied(Path bigTextFilePath) throws Exception{
		
		try {
			if(! Files.exists(bigTextFilePath)) {
				System.out.println("NOT exists BigTextFile: " + bigTextFilePath);
				return false;
			}
		}catch (Exception e) {
			System.out.println("EXCEPTION from Files.exists(): " + e.getMessage());
			throw e;
		}
		
		try {
			long bigTextFileSize = Files.size(bigTextFilePath);
			System.out.println("BigTextFile Size = " + bigTextFileSize);
			if(bigTextFileSize > Integer.MAX_VALUE) {
				System.out.println("BigTextFile size is to big. Max size = " + Integer.MAX_VALUE + " Bytes.");
				return false;
			}else if(bigTextFileSize < FileSize.ONE_MEGA_BYTES) {
				System.out.println("BigTextFile size is to small. Min size = " + FileSize.ONE_MEGA_BYTES + " Bytes.");
				return false;
			}
		}catch (Exception e) {
			System.out.println("EXCEPTION from File.size(): " + e.getMessage());
			throw e;
		}
		
		return true;
	}
}
