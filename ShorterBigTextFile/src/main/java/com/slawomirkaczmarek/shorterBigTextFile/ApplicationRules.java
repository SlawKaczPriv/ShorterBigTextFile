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
		
//		long bigTextFileSize = bigTextFile.getSize();
		int comparing = bigTextFile.getSize().compareTo(destinationTextFile.getSize());
		if(comparing < 0) {
//		if(bigTextFileSize < appProperties.megaBytes.getBytes()) {
			System.out.println("Size of new short file is bigger than size of bigTextFile.");
			return false;
//		}else if(bigTextFileSize == appProperties.megaBytes.getBytes()) {
		}else if(comparing == 0) {
			System.out.println("Size of new short file is equals of bigTextFile size.");
			return false;
		}
		
		return true;
	}
}
