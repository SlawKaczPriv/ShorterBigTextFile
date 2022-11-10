package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Application_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Commons.createBigTextFile(Commons.BIG_TEXT_FILE_PATH);
	}

//	@Disabled
	@Test
	public void testPrintProps() throws Exception {
		
//		Properties props = new Properties();
//		props.put("key1", "value1");
//		props.put("key2", "value2");
//		Application application = new Application(props);
//		application.printProps();
//		fail("Not yet implemented");
		
		
		Path shortTextFilePath = Paths.get("src/test/resources/shortTextFile.txt");
//		Files.deleteIfExists(shortTextFilePath);
		Commons.deleteIfExists(shortTextFilePath, "Application_Test");
		
		String[] args = new String[] {Commons.BIG_TEXT_FILE_PATH.toString(),
				"src/test/resources/shortTextFile.txt", "2"};
		
		Application.main(args);
		
		assertTrue(Files.exists(shortTextFilePath));
		assertEquals(2, Files.size(shortTextFilePath) / FileSize.ONE_MEGA_BYTES);
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

	@Test
	public void applicatin_Test_defaultSize() throws Exception {
		
		Path shortTextFilePath = Paths.get("src/test/resources/shortTextFile.txt");
		Commons.deleteIfExists(shortTextFilePath, "Application_Test");
		
		String[] args = new String[] {Commons.BIG_TEXT_FILE_PATH.toString(),
				"src/test/resources/shortTextFile.txt"};
		
		Application.main(args);
		
		assertTrue(Files.exists(shortTextFilePath));
		assertEquals(1, Files.size(shortTextFilePath) / FileSize.ONE_MEGA_BYTES);
	}
}