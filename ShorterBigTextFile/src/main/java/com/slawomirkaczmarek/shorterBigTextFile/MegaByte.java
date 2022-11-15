package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class MegaByte {

	/** 1_048_476 Bytes */
	public static final int ONE_MEGA_BYTES = (int) Math.pow(2, 20);
	/** 8_796_093_022_207 [MB] Mega Bytes */
	public static final long MAX_VALUE = Long.MAX_VALUE / ONE_MEGA_BYTES;
	
	private final long megaByteValue;
	private final long byteValue;
	
	/**
	 * 
	 * @param megaByteValue
	 */
	MegaByte(long megaByteValue) {
		
		if(megaByteValue < 0) {
			this.megaByteValue = -1;
			this.byteValue = -1;
		}else if(megaByteValue > MAX_VALUE) {
			this.megaByteValue = -1;
			this.byteValue = -1;
		}else {
			this.megaByteValue = megaByteValue;
			this.byteValue = megaByteValue * ONE_MEGA_BYTES;
		}
	}
}
