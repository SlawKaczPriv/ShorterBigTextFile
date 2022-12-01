package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class ShorterTextFileRules {
	
	/** 
	 * Not private because is needed for JUnit tests.
	 * 2_147_483_647 Bytes
	 */
	static final Byte UPPER_LIMIT = new Byte(Integer.MAX_VALUE);
	/** 
	 * Not private because is needed for JUnit tests.
	 * 1_048_476 Bytes
	 */
	static final Byte LOWER_LIMIT = Byte.ONE_MEGA_BYTES;
	
	// Public or default constructor is not needed.
	// Prevents instantiation.
	private ShorterTextFileRules() {}
	
	static boolean areSatisfied(DestinationFile destinationTextFile){
		
		if(destinationTextFile.exists()) {
			if(! destinationTextFile.delete()) {
				return false;
			}
		}
		
		if(destinationTextFile.getSize().compareTo(UPPER_LIMIT) > 0) {
			System.out.println("FAULT. To big NewShorterTextFile size. Max value:"
					+ UPPER_LIMIT + " Bytes. Requested size: " + destinationTextFile.getSize().longVal() + " Bytes");
			return false;
		}else if(destinationTextFile.getSize().compareTo(LOWER_LIMIT) < 0) {
			System.out.println("FAULT. To small NewShorterTextFile size. Min value: "
					+ LOWER_LIMIT + " MB. Requested size: " + destinationTextFile.getSize().longVal() + " Bytes");
			return false;
		}
	
		return true;
	}
}
