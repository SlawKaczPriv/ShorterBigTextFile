package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */
class Arguments {
	
	private boolean successfullyInitialized;

	final Path sourceFilePath;
	final Path destinationFilePath;
	final MegaByte megaBytes;

	/**
	 * 
	 * @param args
	 */
	Arguments(String[] args) throws IllegalArgumentException {
		
		if(args.length != 3) {
			throw new IllegalArgumentException("args values: " + args);
		}
		
		this.successfullyInitialized = true;
		
		this.sourceFilePath = sourceFilePath(args[0]);
		this.destinationFilePath = destinationFilePath(args[1]);
		this.megaBytes = megaBytes(args[2]);
	}

	private Path sourceFilePath(String path) {
		
		try {
			return Paths.get(path);
		}catch (Exception e) {
			System.out.println("ERROR bigTextFilePath. Message: "
					+ e.getMessage());
			this.successfullyInitialized = false;
			return Paths.get("");
		}
	}

	private Path destinationFilePath(String path) {
		
		try {
			return Paths.get(path);
		}catch (Exception e) {
			System.out.println("ERROR shorterTextFilePath. Message: "
					+ e.getMessage());
			this.successfullyInitialized = false;
			return Paths.get("");
		}
	}

	private MegaByte megaBytes(String size) {
		
		try {
			return new MegaByte(size);
		}catch (NumberFormatException e) {
			System.out.println("ERROR NumberFormatException. Argument DestinationTextFileSize is not valid. Message: "
					+ e.getMessage());
//			logger.error("Argument DestinationTextFileSize is not valid. Message: "
//					+ e.getMessage());
			this.successfullyInitialized = false;
			return new MegaByte("0");
		}catch (IllegalArgumentException e) {
			System.out.println("ERROR IllegalArgumentException. Argument DestinationTextFileSize is not valid. Message: "
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
