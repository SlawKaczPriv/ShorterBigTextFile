package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class ShorterBigTextFileRules {
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ShorterBigTextFileRules() {}

//	static boolean areSatisfied(AppProperties appProperties) throws Exception {
	static boolean areSatisfied(AppProperties appProperties){
		
		Path path = appProperties.newShorterTextFilePath;
//		try {
			if(Files.exists(path)) {
				try {
					Files.delete(path);
					System.out.println("Deleted ShorterTextFile: " + path);
				}catch (Exception e) {
					System.out.println("EXCEPTION from Files.deleteIfExists(): " + e.getMessage());
//					throw e;
				}
			}
//		}catch (Exception e) {
//			System.out.println("EXCEPTION from Files.exists(): " + e.getMessage());
//			throw e;
//		}
		
		double size = appProperties.newShorterTextFileSize.megaBytes();
		if(Double.compare(size, FileSize.MAX_MEGA_BYTES) > 0) {
			System.out.println("To big NewShorterTextFile size. Max value:"
					+ FileSize.MAX_MEGA_BYTES + " MB.");
			return false;
		}else if(Double.compare(size, FileSize.MIN_MEGA_BYTES) < 0) {
			System.out.println("To small NewShorterTextFile size. Min value: "
					+ FileSize.MIN_MEGA_BYTES + " MB.");
			return false;
		}
	
		return true;
	}
}
