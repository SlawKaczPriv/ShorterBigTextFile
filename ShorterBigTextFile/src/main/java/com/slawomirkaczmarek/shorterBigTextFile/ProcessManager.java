package com.slawomirkaczmarek.shorterBigTextFile;

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
		
		if(! arguments.isSuccessfullyInitialized()) {
			System.out.println("Something went wrong. See log file. Application Exit.");
			return;
		}
		
		bigTextFile = new SourceFile(arguments.sourceFilePath);
		
		if(! BigTextFileRules.areSatisfied(bigTextFile)) {
			return;
		}
		
//		destinationTextFile = new DestinationFile(arguments.shorterTextFilePath, arguments.shorterTextFileSize);
		FileSize fileSize = new FileSize(arguments.megaBytes);
		destinationTextFile = new DestinationFile(arguments.destinationFilePath, fileSize);
		
//		if(! ShorterTextFileRules.areSatisfied(arguments)) {
		if(! ShorterTextFileRules.areSatisfied(destinationTextFile)) {
			return;
		}
		
		if(! ApplicationRules.areSatisfied(bigTextFile, arguments)) {
			return;
		}
		
		// All checking rules passed.
		// Running Main Functionality of application.
//		bigTextFile.shortenTo(arguments.shorterTextFilePath, arguments.shorterTextFileSize.bytes());
		bigTextFile.shortenTo(arguments.destinationFilePath, fileSize.bytes());
	}
}
