package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class SourceFile_Test {
	
	private static final Path pathToFile3MBsize = Paths.get("src/test/resources/textFile3MBsize.txt");
	private static final Path pathToFile1MBsize = Paths.get("src/test/resources/textFile1MBsize.txt");
	
	@AfterAll
	static void afterAll() throws Exception {
		
		Files.deleteIfExists(pathToFile3MBsize);
		Files.deleteIfExists(pathToFile1MBsize);
	}

	@Test
	void shortenTo_test() {
		fail("Not yet implemented");
	}

	@Test
	void exists_test_false() {
		
		// Given
		Path path = Paths.get("notExists");
		SourceFile sourceFile = new SourceFile(path);
		
		// Then
		assertFalse(sourceFile.exists);
	}

	@Test
	void exists_test_true() throws Exception {
		
		// Given
		Commons.createTextFile(pathToFile1MBsize, 1);
		SourceFile sourceFile = new SourceFile(pathToFile1MBsize);
		
		// Then
		assertTrue(sourceFile.exists);
	}

	@Test
	void getSize_test() throws Exception {
		
		// Given
		Commons.createTextFile(pathToFile1MBsize, 1);
		SourceFile actual = new SourceFile(pathToFile1MBsize);
		
		// Then
		assertEquals(Byte.ONE_MEGA_BYTES, actual.getSize());
	}

	@Test
	void getSize_test_fileDoesNotExist() throws Exception {
		
		// Given
		Path path = Paths.get("notExists");
		SourceFile actual = new SourceFile(path);
		
		// Then
		assertEquals(new Byte(0), actual.getSize());
	}
}
