package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Arguments_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Disabled
	@Test
	final void test_onlyOneArgument() {

		// Given
		String[] args = new String[] {"source"};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("");
//		MegaByte megaBytes = new MegaByte(Arguments.DEFAULT_SIZE);
		
		// Then
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
//		assertEquals(megaBytes, appProp.megaBytes);
	}

	@Disabled
	@Test
	final void test_noArguments() throws Exception{
		
		// Given
		String[] args = new String[] {};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("");
		Path dest = Paths.get("");
//		MegaByte megaBytes = new MegaByte(Arguments.DEFAULT_SIZE);
		
		// Then
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
//		assertEquals(megaBytes, appProp.megaBytes);
	}

	@Disabled
	@Test
	final void test_twoArguments() {
		
		// Given
		String[] args = new String[] {"source", "dest"};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
//		MegaByte megaBytes = new MegaByte(Arguments.DEFAULT_SIZE);

		// Then
		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
//		assertEquals(megaBytes, appProp.megaBytes);
	}

	@Test
	final void test_threeArgumentsSuccessfully() {
		
		// Given
		String[] args = new String[] {"source", "dest", "2"};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		MegaByte megaBytes = new MegaByte("2");
		
		// Then
		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
		assertEquals(megaBytes, appProp.megaBytes);
	}

	@Test
	final void test_destinationFileSizeNotVaidatingToLongType() {
		
		// Given
		String[] args = new String[] {"source", "dest", "2.9"};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		MegaByte megaBytes = new MegaByte("0");
		
		// Then
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
		assertEquals(megaBytes, appProp.megaBytes);
	}

	// Edge case
	@Test
	final void test_destinationFileSizeToBig() {
		
		// Given
		String[] args = new String[] {"source", "dest", String.valueOf(MegaByte.MAX_VALUE + 1)};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		MegaByte megaBytes = new MegaByte("0");
		
		// Then
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
		assertEquals(megaBytes, appProp.megaBytes);
	}

//	Edge case
	@Test
	final void test_destinationFileSizeToSmall() {
		
		// Given
		String[] args = new String[] {"source", "dest", String.valueOf(MegaByte.MIN_VALUE - 1)};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		MegaByte megaBytes = new MegaByte("0");
		
		// Then
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
		assertEquals(megaBytes, appProp.megaBytes);
	}

	// Edge case
	@Test
	final void test_destinationFileSizeMaxValue() {
		
		// Given
		String[] args = new String[] {"source", "dest", String.valueOf(MegaByte.MAX_VALUE)};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		MegaByte megaBytes = new MegaByte(String.valueOf(MegaByte.MAX_VALUE));
		
		// Then
		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
		assertEquals(megaBytes, appProp.megaBytes);
	}

//	Edge case
	@Test
	final void test_destinationFileSizeMinValue() {
		
		// Given
		String[] args = new String[] {"source", "dest", String.valueOf(MegaByte.MIN_VALUE)};
		Arguments appProp = new Arguments(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		MegaByte megaBytes = new MegaByte("0");
		
		// Then
		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.sourceFilePath);
		assertEquals(dest, appProp.destinationFilePath);
		assertEquals(megaBytes, appProp.megaBytes);
	}
}
