package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.IOException;

/**
 * 
 */
class ProcessManager {

	private final Arguments arguments;

	/**
	 * 
	 * @param args
	 */
	ProcessManager(String[] args) {
		this.arguments = new Arguments(args);
	}

	/**
	 * 
	 */
	void run() {
		
		SourceFile bigTextFile;
		DestinationFile shorterTextFile;
		int shorterTextFileSize;
		
		if(! arguments.isSuccessfullyInitialized()) {
			return;
		}
		
		bigTextFile = new SourceFile(arguments.sourceFilePath);
		
		if(! BigTextFileRules.areSatisfied(bigTextFile)) {
			return;
		}
		
		Byte destFileSize = arguments.megaBytes.getBytes();
		shorterTextFile = new DestinationFile(arguments.destinationFilePath, destFileSize);
		
		if(! ShorterTextFileRules.areSatisfied(shorterTextFile)) {
			return;
		}else {
			shorterTextFileSize = (int) destFileSize.longVal();
		}
		
		if(! ApplicationRules.areSatisfied(bigTextFile, shorterTextFile)) {
			return;
		}
		
		// All checking rules passed.
		
		// Running Main Functionality of application.
		try {
			bigTextFile.shortenTo(arguments.destinationFilePath, shorterTextFileSize);
		} catch (IllegalArgumentException | IOException e) {
			System.out.println("EXCEPTION form SourceFile.shortenTo " + e.getMessage());
			e.printStackTrace();
		}
	}
}
