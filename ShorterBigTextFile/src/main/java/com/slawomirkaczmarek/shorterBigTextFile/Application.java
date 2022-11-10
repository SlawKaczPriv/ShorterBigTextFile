package com.slawomirkaczmarek.shorterBigTextFile;

public class Application {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			System.out.println("No variables: source file path and output file path.");
			System.out.println("Application EXIT.");
			System.exit(1);
		}else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("-help")) {
				System.out.println("shorterBigTextFile-0.0.1-SNAPSHOT.jar [sourceFilePath] [destinationFilePath] (optional)[destinationFileSize] in MegaBytes");
				System.exit(0);
			}else {
				System.out.println("No variable: output file path.");
				System.out.println("Application EXIT.");
				System.exit(1);
			}
		}else if(args.length > 3) {
			System.out.println("To many variables");
			System.out.println("Application EXIT.");
			System.exit(1);
		}
		
//		Application application = new Application(args);
		new ProcessManager(args).start();
		
		System.out.println("App END.");
//		System.exit(0);
		return;
	}

	private final AppProperties appProperties;

	Application(String[] args) {
		
		// Loading properties and checking props rules. ---
		this.appProperties = new AppProperties(args);
		
//		if(! appProperties.isSuccessfullyInitialized()) {
//			System.out.println("Application EXIT.");
//			System.exit(1);
//		}
//		// ------------------------------------------------
//		
//		SourceFile bigTextFile = new SourceFile(appProperties.bigTextFilePath);
//		
//		// Checking bigTextFile rules. --------------------
//		if(! BigTextFileRules.areSatisfied(bigTextFile)) {
//			System.out.println("Application EXIT.");
////			System.exit(0);
//			return;
//		}
//		// -------------------------------------------------
//		
//		// Checking shorterBigTextFile rules. --------------
//		try {
//			if(! ShorterBigTextFileRules.areSatisfied(appProperties)) {
//				System.out.println("Application EXIT.");
//				System.exit(0);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Application EXIT.");
//			System.exit(1);
//		}
//		// --------------------------------------------------
//		
//		// Checking application rules.
//		try {
//			if(! ApplicationRules.areSatisfied(appProperties)) {
//				System.out.println("Application EXIT.");
//				System.exit(0);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Application EXIT.");
//			System.exit(1);
//		}
//		// --------------------------------------------------
//		
//		bigTextFile.shortenTo(appProperties.newShorterTextFilePath, appProperties.newShorterTextFileSize);
	}
}
