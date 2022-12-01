package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class JavaUtils {

	// Public or default constructor is not needed.
	// Prevents instantiation.
	private JavaUtils() { }
	

	/**
	 * 
	 * @param filePath
	 * @return
	 */
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
}
