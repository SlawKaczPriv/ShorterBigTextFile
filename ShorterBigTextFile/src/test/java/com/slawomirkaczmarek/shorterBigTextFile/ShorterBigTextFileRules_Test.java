package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShorterBigTextFileRules_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	// Edge case
	@Test
	void areSatisfied_test_newFileSizeToBig() throws Exception {
		
		// Given
		String[] args = new String[] {"source", "dest", String.valueOf(ShorterTextFileRules.UPPER_LIMIT.value() + 1)};
		Arguments appProps = new Arguments(args);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		
		assertFalse(ShorterTextFileRules.areSatisfied(destinationTextFile));
	}

	// Edge case
	@Test
	void areSatisfied_test_newFileSizeMaxSize() throws Exception {
		
		String[] args = new String[] {"source", "dest", String.valueOf(ShorterTextFileRules.UPPER_LIMIT.value() / Bytes.ONE_MEGA_BYTE.value())};
		Arguments appProps = new Arguments(args);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		assertTrue(ShorterTextFileRules.areSatisfied(destinationTextFile));
	}
	
	// Edge case
	@Test
	void areSatisfied_test_newFileSizeToSmall() throws Exception {
		
		String[] args = new String[] {"source", "dest", String.valueOf(ShorterTextFileRules.LOWER_LIMIT.value() - 1)};
		Arguments appProps = new Arguments(args);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		assertFalse(ShorterTextFileRules.areSatisfied(destinationTextFile));
	}
	
	// Edge case
	@Test
	void areSatisfied_test_newFileSizeMinSize() throws Exception {
		
		String[] args = new String[] {"source", "dest", String.valueOf(ShorterTextFileRules.LOWER_LIMIT.value() / Bytes.ONE_MEGA_BYTE.value())};
		Arguments appProps = new Arguments(args);
		FileSize fileSize = new FileSize(appProps.megaBytes);
		DestinationFile destinationTextFile = new DestinationFile(appProps.destinationFilePath, fileSize);
		
		assertTrue(ShorterTextFileRules.areSatisfied(destinationTextFile));
	}
}
