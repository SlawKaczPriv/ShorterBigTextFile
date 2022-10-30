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
	final void isSuccessfullyInitialized_test() {

		String[] args = new String[] {"source"};
		AppProperties appProp = new AppProperties(args);
		Path source = Paths.get("source");
		Path dest = Paths.get("");
		FileSize fileSize = new FileSize(-1 * FileSize.ONE_MEGA_BYTES);
		
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.newShorterTextFilePath);
		assertEquals(fileSize, appProp.newShorterTextFileSize);
		
		args = new String[] {};
		appProp = new AppProperties(args);
		source = Paths.get("");
		dest = Paths.get("");
		fileSize = new FileSize(-1 * FileSize.ONE_MEGA_BYTES);
		
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.newShorterTextFilePath);
		assertEquals(fileSize, appProp.newShorterTextFileSize);
		
		args = new String[] {"source", "dest"};
		appProp = new AppProperties(args);
		source = Paths.get("source");
		dest = Paths.get("dest");
		fileSize = new FileSize(FileSize.DEFAULT_SIZE);

		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.newShorterTextFilePath);
		assertEquals(fileSize, appProp.newShorterTextFileSize);
		
		
		args = new String[] {"source", "dest", "2"};
		appProp = new AppProperties(args);
		source = Paths.get("source");
		dest = Paths.get("dest");
		fileSize = new FileSize(2 * FileSize.ONE_MEGA_BYTES);
		
		assertTrue(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.newShorterTextFilePath);
		assertEquals(fileSize, appProp.newShorterTextFileSize);
		
		args = new String[] {"source", "dest", "2.9"};
		appProp = new AppProperties(args);
		source = Paths.get("source");
		dest = Paths.get("dest");
		fileSize = new FileSize(-1 * FileSize.ONE_MEGA_BYTES);
		
		assertFalse(appProp.isSuccessfullyInitialized());
		assertEquals(source, appProp.bigTextFilePath);
		assertEquals(dest, appProp.newShorterTextFilePath);
		assertEquals(fileSize, appProp.newShorterTextFileSize);
	}
}
