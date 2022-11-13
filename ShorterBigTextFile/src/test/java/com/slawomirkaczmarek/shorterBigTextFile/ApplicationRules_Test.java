package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApplicationRules_Test {
	
	private static final Path PATH_TO_FILE_3MB_SIZE = Paths.get("src/test/resources/textFile3MBsize.txt");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Commons.createTextFile(PATH_TO_FILE_3MB_SIZE, 3);
	}

	@AfterAll
	static void afterAll() throws Exception {
		Files.deleteIfExists(PATH_TO_FILE_3MB_SIZE);
	}

	@Test
	void sourceFileSize_lessThan_destinationFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "blex", "4"};
		AppProperties appProps = new AppProperties(args);
//		Files files = mock(Files.class);
//		when(files.size(appProps.bigTextFilePath)).thenReturn((long) 2);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertFalse(areSatisfied);
	}

	@Test
	void sourceFileSize_equals_destinationFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "blex", "3"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertFalse(areSatisfied);
	}

	@Test
	void sourceFileSize_biggerThan_destinationFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "destinationFilePath", "2"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertTrue(areSatisfied);
	}

	@Test
	void destinationFileDefaultSize_lessThan_sourceFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "destinationFilePath"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertTrue(areSatisfied);
	}
	


	@Test
	void sourceFileNotExists_Test() throws Exception {
		
		// Given
		String[] args = {"fileNotExists", "destinationFilePath", "2"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertFalse(areSatisfied);
	}
}
