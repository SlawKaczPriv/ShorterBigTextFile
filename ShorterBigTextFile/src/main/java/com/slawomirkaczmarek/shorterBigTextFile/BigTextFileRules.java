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
			System.out.println("ERROR. Not exists BigTextFile: " + bigTextFile);
			return false;
		}
		
		if(bigTextFile.getSize().compareTo(Byte.ONE_MEGA_BYTES) <= 0) {
			System.out.println("FAULT. BigTextFile size is to small. Min size have to be more than 1 MB (Bytes "
					+ Byte.ONE_MEGA_BYTES.longVal() + ")");
			return false;
		}
		
		return true;
	}
}
