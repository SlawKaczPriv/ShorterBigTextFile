package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApplicationRules_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void souceFileSize_lessThan_destinationFileSize_Test() throws Exception {
		
		// Given
		String[] args = {Commons.BIG_TEXT_FILE_PATH.toString(), "blex", "1200"};
		AppProperties appProps = new AppProperties(args);
//		Files files = mock(Files.class);
//		when(files.size(appProps.bigTextFilePath)).thenReturn((long) 2);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertFalse(areSatisfied);
	}

	@Test
	void destinationFileSize_lessThan_souceFileSize_Test() throws Exception {
		
		// Given
		String[] args = {Commons.BIG_TEXT_FILE_PATH.toString(), "destinationFilePath", "120"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertTrue(areSatisfied);
	}

	@Test
	void destinationFileDefaultSize_lessThan_souceFileSize_Test() throws Exception {
		
		// Given
		String[] args = {Commons.BIG_TEXT_FILE_PATH.toString(), "destinationFilePath"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertTrue(areSatisfied);
	}
	


	@Test
	void souceFileNotExists_Test() throws Exception {
		
		// Given
		String[] args = {"fileNotExists", "destinationFilePath", "120"};
		AppProperties appProps = new AppProperties(args);
		
		// When
		boolean areSatisfied = ApplicationRules.areSatisfied(appProps);
		
		// Then
		assertFalse(areSatisfied);
	}
}
