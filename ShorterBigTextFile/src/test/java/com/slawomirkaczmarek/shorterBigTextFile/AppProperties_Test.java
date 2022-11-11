package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppProperties_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	final void test1_test() {

		String[] args = new String[] {"source"};
		
		AppProperties appProp = new AppProperties(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("");
		FileSize fileSize = new FileSize(FileSize.DEFAULT_SIZE);
		
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.shorterTextFilePath);
		assertEquals(fileSize, appProp.shorterTextFileSize);
	}

	@Test
	final void test2_test() {
		
		String[] args = new String[] {};
		
		AppProperties appProp = new AppProperties(args);
		Path source = Paths.get("");
		Path dest = Paths.get("");
		FileSize fileSize = new FileSize(FileSize.DEFAULT_SIZE);
		
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.shorterTextFilePath);
		assertEquals(fileSize, appProp.shorterTextFileSize);
	}

	@Test
	final void test3_test() {
		
		String[] args = new String[] {"source", "dest"};
		
		AppProperties appProp = new AppProperties(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		FileSize fileSize = new FileSize(FileSize.DEFAULT_SIZE);

		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.shorterTextFilePath);
		assertEquals(fileSize, appProp.shorterTextFileSize);
	}

	@Test
	final void test4_test() {
		
		String[] args = new String[] {"source", "dest", "2"};
		
		AppProperties appProp = new AppProperties(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		FileSize fileSize = new FileSize(2 * FileSize.ONE_MEGA_BYTES);
		
		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.shorterTextFilePath);
		assertEquals(fileSize, appProp.shorterTextFileSize);
	}

	@Test
	final void test5_test() {
		
		String[] args = new String[] {"source", "dest", "2.9"};
		
		AppProperties appProp = new AppProperties(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("dest");
		FileSize fileSize = new FileSize(-1);
		
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.shorterTextFilePath);
		assertEquals(fileSize, appProp.shorterTextFileSize);
	}
}
