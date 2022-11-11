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
		
		if(bigTextFile.getSize() > Long.MAX_VALUE) {
			System.out.println("BigTextFile size is to big. Max size = " + Long.MAX_VALUE + " Bytes.");
			return false;
		}else if(bigTextFile.getSize() < FileSize.ONE_MEGA_BYTES) {
			System.out.println("BigTextFile size is to small. Min size = 1 MB (bytes: " + FileSize.ONE_MEGA_BYTES);
			return false;
		}
		
		return true;
	}
}
