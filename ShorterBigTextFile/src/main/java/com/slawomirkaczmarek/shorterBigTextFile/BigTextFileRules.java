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
		
		if(bigTextFile.getSize() <= MegaByte.ONE_MEGA_BYTES) {
			System.out.println("BigTextFile size is to small. Min size have to be more than 1 MB (Bytes "
					+ MegaByte.ONE_MEGA_BYTES + ")");
			return false;
		}
		
		return true;
	}
}
