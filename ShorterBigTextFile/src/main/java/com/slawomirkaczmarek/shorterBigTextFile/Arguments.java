package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */
class Arguments {
	
	public static final String DEFAULT_SIZE = "1";
	
	private boolean successfullyInitialized;

	final Path sourceFilePath;
	final Path destinationFilePath;
	final MegaByte megaBytes;

	/**
	 * 
	 * @param args
	 */
	Arguments(String[] args) {
		
		this.successfullyInitialized = true;
		
		this.sourceFilePath = bigTextFilePath(args);
		this.destinationFilePath = shorterTextFilePath(args);
		this.megaBytes = megaBytes(args);
	}

	private Path bigTextFilePath(String[] args) {
		
		try {
			return Paths.get(args[0]);
		}catch (Exception e) {
			System.out.println("ERROR bigTextFilePath. Message: "
					+ e.getMessage());
			this.successfullyInitialized = false;
			return Paths.get("");
		}
	}

	private Path shorterTextFilePath(String[] args) {
		
		try {
			return Paths.get(args[1]);
		}catch (Exception e) {
			System.out.println("ERROR shorterTextFilePath. Message: "
					+ e.getMessage());
			this.successfullyInitialized = false;
			return Paths.get("");
		}
	}

	private MegaByte megaBytes(String[] args) {
		
		if(args.length == 3) {
			return megaBytes(args[2]);
		}else {
			System.out.println("Argument DestinationTextFileSize is set as default: "
					+ DEFAULT_SIZE
					+ " MB.");
			return megaBytes(DEFAULT_SIZE);
		}
	}

	private MegaByte megaBytes(String size) {
		
		try {
			return new MegaByte(size);
		}catch (NumberFormatException e) {
			System.out.println("ERROR. Argument DestinationTextFileSize is not valid. Message: "
					+ e.getMessage());
//			logger.error("Argument DestinationTextFileSize is not valid. Message: "
//					+ e.getMessage());
			this.successfullyInitialized = false;
			return new MegaByte("0");
		}catch (IllegalArgumentException e) {
			System.out.println("ERROR. Argument DestinationTextFileSize is not valid. Message: "
					+ e.getMessage());
//			logger.error("Argument DestinationTextFileSize is not valid. Message: "
//					+ e.getMessage());
			this.successfullyInitialized = false;
			return new MegaByte("0");
		}
	}

	@Override
	public String toString() {
		
		return new StringBuilder()
				.append("AppProperties [bigTextFilePath=").append(sourceFilePath)
				.append(" newShorterTextFilePath=").append(destinationFilePath)
				.append(" newShorterTextFileSize=").append(megaBytes).append(" MB]")
				.toString();
	}

	/**
	 * 
	 * @return
	 */
	boolean isSuccessfullyInitialized() {
		return successfullyInitialized;
	}
}
