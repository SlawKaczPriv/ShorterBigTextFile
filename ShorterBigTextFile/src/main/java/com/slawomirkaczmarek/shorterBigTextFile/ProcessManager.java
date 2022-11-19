package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Path;

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
		DestinationFile destinationTextFile;
		FileSize fileSize;
		
		if(! arguments.isSuccessfullyInitialized()) {
			System.out.println("Something went wrong. See log file. Application Exit.");
			return;
		}
		
		bigTextFile = new SourceFile(arguments.sourceFilePath);
		
		if(! BigTextFileRules.areSatisfied(bigTextFile)) {
			return;
		}
		
		fileSize = new FileSize(arguments.megaBytes);
		destinationTextFile = new DestinationFile(arguments.destinationFilePath, fileSize);
		
		if(! ShorterTextFileRules.areSatisfied(destinationTextFile)) {
			return;
		}
		
		if(! ApplicationRules.areSatisfied(bigTextFile, destinationTextFile)) {
			return;
		}
		
		// All checking rules passed.
		// Running Main Functionality of application.
		bigTextFile.shortenTo(arguments.destinationFilePath, fileSize.bytes());
	}
}
