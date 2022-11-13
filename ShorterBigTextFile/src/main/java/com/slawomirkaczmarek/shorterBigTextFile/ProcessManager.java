package com.slawomirkaczmarek.shorterBigTextFile;

/**
 * 
 */
class ProcessManager {

	private final AppProperties appProperties;

	/**
	 * 
	 * @param args
	 */
	ProcessManager(String[] args) {
		this.appProperties = new AppProperties(args);
	}

	/**
	 * 
	 */
	void run() {
		
		SourceFileImp bigTextFile;
		
		if(! appProperties.isSuccessfullyInitialized()) {
			return;
		}
		
		bigTextFile = new SourceFileImp(appProperties.bigTextFilePath);
		
		if(! BigTextFileRules.areSatisfied(bigTextFile)) {
			return;
		}
		
		if(! ShorterTextFileRules.areSatisfied(appProperties)) {
			return;
		}
		
		if(! ApplicationRules.areSatisfied(appProperties)) {
			return;
		}
		
		// All checking rules passed.
		// Running Main Functionality of application.
		bigTextFile.shortenTo(appProperties.shorterTextFilePath, appProperties.shorterTextFileSize.bytes());
	}
}
