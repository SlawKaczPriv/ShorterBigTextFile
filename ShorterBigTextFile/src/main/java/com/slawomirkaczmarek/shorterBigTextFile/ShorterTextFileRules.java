package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class ShorterTextFileRules {
	
//	/** 2047 [MB] Mega Bytes */
	static final Byte UPPER_LIMIT = new Byte(Integer.MAX_VALUE);
//	/** 1 [MB] Mega Bytes */
	static final Byte LOWER_LIMIT = Byte.ONE_MEGA_BYTE;
	
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
					+ UPPER_LIMIT + " Bytes. Requested size: " + destinationTextFile.getSize().value() + " Bytes");
			return false;
		}else if(destinationTextFile.getSize().compareTo(LOWER_LIMIT) < 0) {
			System.out.println("To small NewShorterTextFile size. Min value: "
					+ LOWER_LIMIT + " MB. Requested size: " + destinationTextFile.getSize().value() + " Bytes");
			return false;
		}
	
		return true;
	}
}
