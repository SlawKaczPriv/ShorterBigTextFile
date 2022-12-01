package com.slawomirkaczmarek.shorterBigTextFile;

import java.util.Properties;

/**
 * 
 */
public class Application {
	
	private static final String PROPERTY_FILE_PATH = "ShortTextFile.properties";
	/** Unit [MB] MegaBytes */
	private static final String DESTINATION_FILE_DEFAULT_SIZE = "1";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Properties properties = JavaUtils.loadProperties(PROPERTY_FILE_PATH);
		
		int argsAmount = args.length;
		
		if(argsAmount == 3) {
			runAppForThreeArgs(args);
		}else if(argsAmount == 2) {
			runAppForTwoArgs(args, properties);
		}else if(argsAmount == 1) {
			runAppForOneArg(args);
		}else if(argsAmount == 0) {
			System.out.println("ERROR. No variables.");
			printHelp();
		}else {
			System.out.println("ERROR. To many variables");
			printHelp();
		}
//		
//		System.out.println("ShortTextFile app END.");
//		System.exit(0);
		return;
	}

	private static void runAppForThreeArgs(String[] args) {
		
		if(isIntegerNumber(args[2])) {
			new ProcessManager(args).run(); // Running application.
//				System.out.println("ShortTextFile app END.");
		}else {
			System.out.println("ERROR. Argument size of destination file must be integer number.");
			printHelp();
		}
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

	private static void runAppForTwoArgs(String[] args, Properties properties) {
		
		String[] arguments = new String[] {
				args[0],
				args[1],
				properties.getProperty("destinationFile.defaultSize", DESTINATION_FILE_DEFAULT_SIZE)
			};
		// System.out.println("INFO. Destination file size is set to: " + arguments[2] + " [MB] MegaBytes.");
		
		runAppForThreeArgs(arguments);
	}

	private static void runAppForOneArg(String[] args) {
		
		if(args[0].equalsIgnoreCase("-help")) {
			printHelp();
		}else {
			System.out.println("ERROR. No argument: path of destination file.");
			printHelp();
		}
	}
}
