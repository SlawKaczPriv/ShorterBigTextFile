package com.slawomirkaczmarek.shorterBigTextFile;

public class Application {

	public static void main(String[] args) {
		
		int argsAmount = args.length;
		
		if(argsAmount == 2 || argsAmount == 3) {
			new ProcessManager(args).run();
		}else if(argsAmount == 0) {
			System.out.println("No variables: source file path and output destination file path.");
			printHelp();
		}else if(argsAmount == 1) {
			if(args[0].equalsIgnoreCase("-help")) {
				printHelp();
			}else {
				System.out.println("No variable: output destination file path.");
				printHelp();
			}
		}else {
			System.out.println("To many variables");
			printHelp();
		}
		
		System.out.println("App END.");
//		System.exit(0);
		return;
	}

	private static void printHelp() {
		
		Package mainPackage = Application.class.getPackage();
		String version = mainPackage.getImplementationVersion();
//		String groupId = mainPackage.getName();
//		String artifactId = mainPackage.getImplementationTitle();
//		
//		System.out.println(version);
//		System.out.println(groupId);
//		System.out.println(artifactId);
//		
		System.out.println("shorterBigTextFile-" + version + ".jar [sourceFilePath] [destinationFilePath] (optional)[destinationFileSize] in MegaBytes");
	}
}
