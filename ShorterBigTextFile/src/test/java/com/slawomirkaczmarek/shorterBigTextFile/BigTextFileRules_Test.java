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
		assertTrue(BigTextFileRules.areSatisfied(Commons.BIG_TEXT_FILE_PATH));
	}

	@Test
	void areSatisfied_test_bigTextFileNotExists() throws Exception {
		
		Path fileNotExistsPath = Paths.get("blabla");
		assertFalse(BigTextFileRules.areSatisfied(fileNotExistsPath));
	}
}
