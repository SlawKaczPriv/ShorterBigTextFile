package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BigTextFileRules_Test {
	
	private static final Path PATH_TO_FILE_3MB_SIZE = Paths.get("src/test/resources/textFile3MBsize.txt");
	private static final Path PATH_TO_FILE_1MB_SIZE = Paths.get("src/test/resources/textFile1MBsize.txt");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void afterAll() throws Exception {
		Files.deleteIfExists(PATH_TO_FILE_3MB_SIZE);
		Files.deleteIfExists(PATH_TO_FILE_1MB_SIZE);
	}

	@Test
	void areSatisfied_test_bigTextFileExists() throws Exception {

		Commons.createTextFile(PATH_TO_FILE_3MB_SIZE, 3);
		SourceFile bigTextFile = new SourceFile(PATH_TO_FILE_3MB_SIZE);
		
		assertTrue(BigTextFileRules.areSatisfied(bigTextFile));
	}

	@Test
	void areSatisfied_test_bigTextFileToSmall() throws Exception {

		Commons.createTextFile(PATH_TO_FILE_1MB_SIZE, 1);
		SourceFile bigTextFile = new SourceFile(PATH_TO_FILE_1MB_SIZE);
		
		assertFalse(BigTextFileRules.areSatisfied(bigTextFile));
	}

	@Test
	void areSatisfied_test_bigTextFileNotExists() throws Exception {
		
		Path fileNotExistsPath = Paths.get("bigTextFileNotExists");
		SourceFile fileNotExists = new SourceFile(fileNotExistsPath);
				
		assertFalse(BigTextFileRules.areSatisfied(fileNotExists));
	}
}
