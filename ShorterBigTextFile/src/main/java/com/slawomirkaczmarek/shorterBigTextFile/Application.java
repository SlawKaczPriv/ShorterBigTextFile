package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class Application {

	public static void main(String[] args) {
		
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
		
		System.out.println("App END.");
	}

	private final AppProperties appProperties;

	Application(String[] args) {
		
		// Loading properties and checking props rules. ---
		this.appProperties = new AppProperties(args);
		
		if(! appProperties.isSuccessfullyInitialized()) {
			System.out.println("Application EXIT.");
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
		
		SourceFile bigTextFile = new SourceFile(appProperties.bigTextFilePath);
		bigTextFile.shortenTo(appProperties.newShorterTextFilePath, appProperties.newShorterTextFileSize);
	}
}
