package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class ShorterTextFileRules {
	
//	/** 2047 [MB] Mega Bytes */
	static final int UPPER_LIMIT = Integer.MAX_VALUE;
//	/** 1 [MB] Mega Bytes */
	static final int LOWER_LIMIT = MegaByte.ONE_MEGA_BYTES;
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ShorterTextFileRules() {}
	
	static boolean areSatisfied(DestinationFile destinationTextFile){
		
		if(destinationTextFile.exists()) {
			if(! destinationTextFile.deleteIt()) {
				return false;
			}
		}
		
		if(destinationTextFile.getSize().compareTo(UPPER_LIMIT) > 0) {
			System.out.println("To big NewShorterTextFile size. Max value:"
					+ UPPER_LIMIT + " Bytes. Requested size: " + destinationTextFile.getSize().bytes() + " Bytes");
			return false;
		}else if(destinationTextFile.getSize().compareTo(LOWER_LIMIT) < 0) {
			System.out.println("To small NewShorterTextFile size. Min value: "
					+ LOWER_LIMIT + " MB. Requested size: " + destinationTextFile.getSize().bytes() + " Bytes");
			return false;
		}
	
		return true;
	}
}
