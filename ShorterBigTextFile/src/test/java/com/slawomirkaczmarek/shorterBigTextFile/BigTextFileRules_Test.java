package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BigTextFileRules_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Commons.createBigTextFile(Commons.BIG_TEXT_FILE_PATH);
	}

	@Test
	void areSatisfied_test_bigTextFileExists() throws Exception {
		
		SourceFile bigTextFile = new SourceFile(Commons.BIG_TEXT_FILE_PATH);
		
		assertTrue(BigTextFileRules.areSatisfied(bigTextFile));
	}

	@Test
	void areSatisfied_test_bigTextFileNotExists() throws Exception {
		
		Path fileNotExistsPath = Paths.get("blabla");
		SourceFile fileNotExists = new SourceFile(fileNotExistsPath);
				
		assertFalse(BigTextFileRules.areSatisfied(fileNotExists));
	}
}
