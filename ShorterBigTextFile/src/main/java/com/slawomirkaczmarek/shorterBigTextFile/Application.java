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
		
		new ProcessManager(args).run();
		
		System.out.println("App END.");
//		System.exit(0);
		return;
	}
}
