package com.slawomirkaczmarek.shorterBigTextFile;

public class Application {

	public static void main(String[] args) {
		
		int argsAmount = args.length;
		
		if(argsAmount == 3) {
			
			if(isIntegerNumber(args[2])) {
				new ProcessManager(args).run(); // Running application.
//				System.out.println("ShortTextFile app END.");
			}else {
				System.out.println("Argument destinationFileSize is not integer number.");
				printHelp();
			}
			
		}else if(argsAmount == 2) {
			
			new ProcessManager(args).run(); // Running application.
//			System.out.println("ShortTextFile app END.");
			
		}else if(argsAmount == 1) {
			
			if(args[0].equalsIgnoreCase("-help")) {
				printHelp();
			}else {
				System.out.println("No variable: output destination file path.");
				printHelp();
			}
		}else if(argsAmount == 0) {
			
			System.out.println("No variables: source file path, destination file path and optionally size of destination file.");
			printHelp();
		}else {
			
			System.out.println("To many variables");
			printHelp();
		}
//		
//		System.out.println("ShortTextFile app END.");
//		System.exit(0);
		return;
	}

	private static boolean isIntegerNumber(String arg) {
		
		try {
			Integer.parseInt(arg);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}

	private static void printHelp() {
		
		String version = Application.class.getPackage().getImplementationVersion();
		System.out.println("-help:"
				+ System.lineSeparator() + "\t" + "shorterBigTextFile-" + version + ".jar [sourceFilePath] [destinationFilePath] [destinationFileSize] (in MegaBytes)"
				+ System.lineSeparator() + "\t" + "shorterBigTextFile-" + version + ".jar [sourceFilePath] [destinationFilePath] default size will be used"
				+ System.lineSeparator()
				+ System.lineSeparator() + "\t" + "Examples:"
				+ System.lineSeparator() + "\t" + "java -jar shorterBigTextFile-" + version + ".jar c:\\sourceBigTxtFile.txt c:\\destination.txt 2"
				+ System.lineSeparator() + "\t" + "For Windows system if not set JAVA_HOME:"
				+ System.lineSeparator() + "\t" + "C:\\\"Program Files\"\\Java\\jdk-15.0.2\\bin\\java.exe -jar shorterBigTextFile-" + version + ".jar c:\\sourceBigTxtFile.txt c:\\destination.txt 2");
	}
}
