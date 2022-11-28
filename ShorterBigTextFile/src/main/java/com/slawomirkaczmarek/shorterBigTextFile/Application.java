package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
	
	private static final String DEFAULT_SIZE = "1";

	public static void main(String[] args) {
		
		Properties properties = loadProperties("ShortTextFile.properties");
		System.out.println(properties.getProperty("destinationFile.defaultSize", DEFAULT_SIZE));
		
		int argsAmount = args.length;
		
		if(argsAmount == 3) {
			
			if(isIntegerNumber(args[2])) {
				new ProcessManager(args).run(); // Running application.
//				System.out.println("ShortTextFile app END.");
			}else {
				System.out.println("Argument: size of destination file must be integer number.");
				printHelp();
			}
			
		}else if(argsAmount == 2) {
			
			String[] arguments = new String[] {
					args[0],
					args[1],
					properties.getProperty("destinationFile.defaultSize", DEFAULT_SIZE)
				};
			
			if(isIntegerNumber(arguments[2])) {
				new ProcessManager(arguments).run(); // Running application.
//				System.out.println("ShortTextFile app END.");
			}else {
				System.out.println("Argument: size of destination file must be integer number.");
				printHelp();
			}
			
		}else if(argsAmount == 1) {
			
			if(args[0].equalsIgnoreCase("-help")) {
				printHelp();
			}else {
				System.out.println("No variable: path of destination file.");
				printHelp();
			}
		}else if(argsAmount == 0) {
			
			System.out.println("No variables: path of source file, path of destination file and optionally size of destination file.");
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

	private static Properties properties() {
		
		try (InputStream input = Application.class.getClassLoader().getResourceAsStream("ShortTextFile.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find ShortTextFile.properties");
                return new Properties();
            }

            prop.load(input);
            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
            return new Properties();
        }
	}
	
	public static Properties loadProperties(String filePath) {
		
		Properties properties = new Properties();
		
		try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR. Properties file not found.");
//			logger.error(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR input Properties.");
//			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return properties;
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
