package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
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
	void shortenTo_test() throws Exception{
		
		// Given
		Commons.createTextFile(pathToFile3MBsize, 3);
		Commons.deleteIfExists(pathToFile1MBsize, "shortenTo_test()");
		assertFalse(Files.exists(pathToFile1MBsize));
		SourceFile sourceFile = new SourceFile(pathToFile3MBsize);
		
		// When
		try {
		sourceFile.shortenTo(pathToFile1MBsize, (int) Byte.ONE_MEGA_BYTES.longVal());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// Then
		assertTrue(Files.exists(pathToFile1MBsize));
		assertTrue(Files.exists(pathToFile1MBsize));
		assertEquals(Byte.ONE_MEGA_BYTES.longVal(), Files.size(pathToFile1MBsize));
	}

	@Test
	void newShortenTo_test() throws Exception{
		
		// Given
		Path path = Paths.get("C:\\Users\\20624\\Desktop\\textFile1MBsize.txt");
		assertTrue(Files.exists(path));
		SourceFile sourceFile = new SourceFile(path);
		System.out.println("path=" + sourceFile.path);
		System.out.println("size=" + Files.size(path));
		
		// When
		sourceFile.newShortenTo();
		
		// Then
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
