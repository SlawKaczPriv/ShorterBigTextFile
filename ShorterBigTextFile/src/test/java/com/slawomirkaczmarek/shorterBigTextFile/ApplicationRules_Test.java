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
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "dest", "4"};
		Arguments appProps = new Arguments(args);
		SourceFile bigTextFile = new SourceFile(appProps.sourceFilePath);
//		Files files = mock(Files.class);
//		when(files.size(appProps.bigTextFilePath)).thenReturn((long) 2);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(bigTextFile, destinationTextFile);
		
		// Then
		assertFalse(areSatisfied);
	}

	@Test
	void sourceFileSize_equals_destinationFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "dest", "3"};
		Arguments appProps = new Arguments(args);
		SourceFile bigTextFile = new SourceFile(appProps.sourceFilePath);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(bigTextFile, destinationTextFile);
		
		// Then
		assertFalse(areSatisfied);
	}

	@Test
	void sourceFileSize_biggerThan_destinationFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "dest", "2"};
		Arguments appProps = new Arguments(args);
		SourceFile bigTextFile = new SourceFile(appProps.sourceFilePath);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(bigTextFile, destinationTextFile);
		
		// Then
		assertTrue(areSatisfied);
	}

	@Test
	void destinationFileDefaultSize_lessThan_sourceFileSize_Test() throws Exception {
		
		// Given
		String[] args = {PATH_TO_FILE_3MB_SIZE.toString(), "dest"};
		Arguments appProps = new Arguments(args);
		SourceFile bigTextFile = new SourceFile(appProps.sourceFilePath);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(bigTextFile, destinationTextFile);
		
		// Then
		assertTrue(areSatisfied);
	}
	


	@Test
	void sourceFileNotExists_Test() throws Exception {
		
		// Given
		String[] args = {"fileNotExists", "dest", "2"};
		Arguments appProps = new Arguments(args);
		SourceFile bigTextFile = new SourceFile(appProps.sourceFilePath);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(bigTextFile, destinationTextFile);
		
		// Then
		assertFalse(areSatisfied);
	}
}
