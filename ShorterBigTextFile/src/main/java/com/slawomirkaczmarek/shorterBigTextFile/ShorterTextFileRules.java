package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class ShorterTextFileRules {
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ShorterTextFileRules() {}
	
	static boolean areSatisfied(AppProperties appProperties){
		
		Path path = appProperties.shorterTextFilePath;
		
		// Delete destination file if exists.
		if(Files.exists(path)) {
			try {
				Files.delete(path);
				System.out.println("Deleted ShorterTextFile: " + path);
			}catch (Exception e) {
				System.out.println("EXCEPTION from Files.delete(): " + e.getMessage());
				return false;
			}
		}
		
		double size = appProperties.shorterTextFileSize.megaBytes();
		if(Double.compare(size, FileSize.MAX_MEGA_BYTES) > 0) {
			System.out.println("To big NewShorterTextFile size. Max value:"
					+ FileSize.MAX_MEGA_BYTES + " MB.");
			return false;
		}else if(Double.compare(size, FileSize.MIN_MEGA_BYTES) < 0) {
			System.out.println("To small NewShorterTextFile size. Min value: "
					+ FileSize.MIN_MEGA_BYTES + " MB. Requested size: " + size);
			return false;
		}
	
		return true;
	}
}
