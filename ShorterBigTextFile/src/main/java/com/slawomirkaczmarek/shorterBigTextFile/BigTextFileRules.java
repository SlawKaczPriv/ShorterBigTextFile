package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class BigTextFileRules {
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private BigTextFileRules() { }

	/**
	 * 
	 * @param bigTextFile
	 * @return
	 */
	static boolean areSatisfied(SourceFile bigTextFile) {
		
		if(! bigTextFile.exists()) {
			System.out.println("NOT exists BigTextFile: " + bigTextFile);
			return false;
		}
		
		if(bigTextFile.getSize() > Integer.MAX_VALUE) {
			System.out.println("BigTextFile size is to big. Max size = " + Integer.MAX_VALUE + " Bytes.");
			return false;
		}else if(bigTextFile.getSize() < FileSize.ONE_MEGA_BYTES) {
			System.out.println("BigTextFile size is to small. Min size = " + FileSize.ONE_MEGA_BYTES + " Bytes.");
			return false;
		}
		
		return true;
	}
}
