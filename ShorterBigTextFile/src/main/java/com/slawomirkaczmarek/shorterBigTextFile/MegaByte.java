package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class MegaByte {
	
	private final long value;
	private final long byteValue;
	
	public MegaByte(long megaByteValue) {
		
		if(megaByteValue < 0) {
			this.value = -1;
			this.byteValue = -1;
		}else {
			this.value = megaByteValue;
			this.byteValue = megaByteValue * FileSize.ONE_MEGA_BYTES;
		}
	}
}
