package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BigTextFileRules_Test {
	
	private static final Path pathToFile3MBsize = Paths.get("src/test/resources/textFile3MBsize.txt");
	private static final Path pathToFile1MBsize = Paths.get("src/test/resources/textFile1MBsize.txt");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void afterAll() throws Exception {
		
		Files.deleteIfExists(pathToFile3MBsize);
//		Commons.deleteIfExists(pathToFile3MBsize, "BigTextFileRules_Test: afterAll()");
		Files.deleteIfExists(pathToFile1MBsize);
	}

	@Test
	void areSatisfied_test_bigTextFileExists() throws Exception {

		// Given
		Commons.createTextFile(pathToFile3MBsize, 3);
		SourceFile bigTextFile = new SourceFile(pathToFile3MBsize);
		
		// Then
		assertTrue(BigTextFileRules.areSatisfied(bigTextFile));
	}

	@Test
	void areSatisfied_test_bigTextFileToSmall() throws Exception {

		// Given
		Commons.createTextFile(pathToFile1MBsize, 1);
		SourceFile bigTextFile = new SourceFile(pathToFile1MBsize);
		
		// Then
		assertFalse(BigTextFileRules.areSatisfied(bigTextFile));
	}

	@Test
	void areSatisfied_test_bigTextFileNotExists() throws Exception {
		
		// Given
		Path fileNotExistsPath = Paths.get("bigTextFileNotExists");
		SourceFile fileNotExists = new SourceFile(fileNotExistsPath);
				
		// Then
		assertFalse(BigTextFileRules.areSatisfied(fileNotExists));
	}
}
