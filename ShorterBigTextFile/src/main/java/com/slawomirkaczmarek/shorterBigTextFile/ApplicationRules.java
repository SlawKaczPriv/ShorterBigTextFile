package com.slawomirkaczmarek.shorterBigTextFile;

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
	static boolean areSatisfied(SourceFile bigTextFile, DestinationFile destinationTextFile) {
		
		int comparing = bigTextFile.getSize().compareTo(destinationTextFile.getSize());
		if(comparing < 0) {
			System.out.println("FAULT. Size of new short file is bigger than size of bigTextFile.");
			return false;
		}else if(comparing == 0) {
			System.out.println("FAULT. Size of new short file is equals of bigTextFile size.");
			return false;
		}
		
		return true;
	}
}
