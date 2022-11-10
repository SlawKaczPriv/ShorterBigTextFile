package com.slawomirkaczmarek.shorterBigTextFile;

class ProcessManager {

	private final AppProperties appProperties;

	ProcessManager(String[] args) {
		this.appProperties = new AppProperties(args);
	}

	void start() {
		
		if(! appProperties.isSuccessfullyInitialized()) {
			System.out.println("Application EXIT.");
			System.exit(1);
		}
		// ------------------------------------------------
		
		SourceFile bigTextFile = new SourceFile(appProperties.bigTextFilePath);
		
		// Checking bigTextFile rules. --------------------
		if(! BigTextFileRules.areSatisfied(bigTextFile)) {
			System.out.println("Application EXIT.");
//			System.exit(0);
			return;
		}
		// -------------------------------------------------
		
		// Checking shorterBigTextFile rules. --------------
		try {
			if(! ShorterBigTextFileRules.areSatisfied(appProperties)) {
				System.out.println("Application EXIT.");
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Application EXIT.");
			System.exit(1);
		}
		// --------------------------------------------------
		
		// Checking application rules.
		try {
			if(! ApplicationRules.areSatisfied(appProperties)) {
				System.out.println("Application EXIT.");
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Application EXIT.");
			System.exit(1);
		}
		// --------------------------------------------------
		
		bigTextFile.shortenTo(appProperties.newShorterTextFilePath, appProperties.newShorterTextFileSize);
	}

}
