package com.slawomirkaczmarek.shorterBigTextFile;

class ProcessManager {

	private final AppProperties appProperties;

	ProcessManager(String[] args) {
		this.appProperties = new AppProperties(args);
	}

	void run() {
		
		SourceFile bigTextFile;
		
		if(! appProperties.isSuccessfullyInitialized()) {
			return;
		}
		
		bigTextFile = new SourceFile(appProperties.bigTextFilePath);
		
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
		// Run Main Functionality of application.
		bigTextFile.shortenTo(appProperties.shorterTextFilePath, appProperties.shorterTextFileSize.bytes());
	}
}
