package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello Application");
		System.out.println(Arrays.asList(args));

		
		if(args.length < 1) {
			System.out.println("No variables: source file path and output file path.");
			System.out.println("Application EXIT.");
			System.exit(1);
		}else if(args.length < 2) {
			System.out.println("No variable: output file path.");
			System.out.println("Application EXIT.");
			System.exit(1);
		}
		
		Application application = new Application(args);
		application.printProps();
	}

	private final AppProperties appProperties;

	Application(String[] args) {
		System.out.println("Application constructor");
		
		// Loading properties and checking props rules. ---
		this.appProperties = new AppProperties(args);
		
		if(! appProperties.isSuccessfullyInitialized()) {
			System.out.println("Application EXIT.");
			System.out.println("props:" + appProperties);
			System.exit(1);
		}
		// ------------------------------------------------
		
		// Checking bigTextFile rules. --------------------
		try {
			if(! BigTextFileRules.areSatisfied(appProperties.bigTextFilePath)) {
				System.out.println("Application EXIT.");
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Application EXIT.");
			System.exit(1);
		}
		// -------------------------------------------------
	}
	
	void printProps() {
		System.out.println("PrintProps:");
		System.out.println(appProperties);
	}
}
