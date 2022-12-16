package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Application_Test {
	
	private static final Path pathToFile3MBsize = Paths.get("src/test/resources/textFile3MBsize.txt");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Commons.createTextFile(pathToFile3MBsize, 3);
	}

	@Disabled
	@Test
	public void testPrintProps() throws Exception {
		
		Path shortTextFilePath = Paths.get("src/test/resources/textFile1MBsize.txt");
//		Files.deleteIfExists(shortTextFilePath);
		Commons.deleteIfExists(shortTextFilePath, "Application_Test");
		
		String[] args = new String[] {pathToFile3MBsize.toString(), shortTextFilePath.toString(), "2"};
		
		Application.main(args);
		
		assertTrue(Files.exists(shortTextFilePath));
		assertEquals(2, Files.size(shortTextFilePath) / Byte.ONE_MEGA_BYTES.longVal());
	}
	
	@Disabled
	@Test
	public void applicatin_Test_bigTextFileNotExists() throws Exception {
		
		Path shortTextFilePath = Paths.get("src/test/resources/shortTextFile.txt");
		Commons.deleteIfExists(shortTextFilePath, "Application_Test");
		
		String[] args = new String[] {"blabla",
				"src/test/resources/shortTextFile.txt", "2"};
		
		Application.main(args);
		
		assertFalse(Files.exists(shortTextFilePath));
	}


	@Disabled
	@Test
	public void applicatin_Test_defaultSize() throws Exception {
		
		Path shortTextFilePath = Paths.get("src/test/resources/shortTextFile.txt");
		Commons.deleteIfExists(shortTextFilePath, "Application_Test");
		
		String[] args = new String[] {pathToFile3MBsize.toString(),
				"src/test/resources/shortTextFile.txt"};
		
		Application.main(args);
		
		assertTrue(Files.exists(shortTextFilePath));
		assertEquals(1, Files.size(shortTextFilePath) / Byte.ONE_MEGA_BYTES.longVal());
	}
	
//	@Test
//	public void megaBytesMaxValue() throws Exception {
//		
//		long MAX_VALUE = Long.MAX_VALUE / ((int) Math.pow(2, 20));
//		System.out.println("Long max val = " + Long.MAX_VALUE);
//		System.out.println("megaBytesMaxValue=" + MAX_VALUE);
//	}
}