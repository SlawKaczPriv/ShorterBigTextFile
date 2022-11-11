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
		
		String[] args = new String[] {"source", "dest", String.valueOf(FileSize.MAX_MEGA_BYTES + 1)};
		AppProperties appProps = new AppProperties(args);
		assertFalse(ShorterTextFileRules.areSatisfied(appProps));
	}

	// Edge case
	@Test
	void areSatisfied_test_newFileSizeMaxSize() throws Exception {
		
		String[] args = new String[] {"source", "dest", String.valueOf(FileSize.MAX_MEGA_BYTES)};
		AppProperties appProps = new AppProperties(args);
		assertTrue(ShorterTextFileRules.areSatisfied(appProps));
	}
	
	// Edge case
	@Test
	void areSatisfied_test_newFileSizeToSmall() throws Exception {
		
		String[] args = new String[] {"source", "dest", String.valueOf(FileSize.MIN_MEGA_BYTES - 1)};
		AppProperties appProps = new AppProperties(args);
		assertFalse(ShorterTextFileRules.areSatisfied(appProps));
	}
	
	// Edge case
	@Test
	void areSatisfied_test_newFileSizeMinSize() throws Exception {
		
		String[] args = new String[] {"source", "dest", String.valueOf(FileSize.MIN_MEGA_BYTES)};
		AppProperties appProps = new AppProperties(args);
		assertTrue(ShorterTextFileRules.areSatisfied(appProps));
	}
	
//	@Test
//	void parsToInt_test() throws Exception {
//		
//		System.out.println("MAX MEGA BYTES=" + FileSize.MAX_MEGA_BYTES);
//		
//		String number = String.valueOf(Integer.MAX_VALUE);
//		System.out.println(number);
//		System.out.println(Integer.parseInt(number));
//		
//		number = String.valueOf((long) Integer.MAX_VALUE + 1);
//		System.out.println(number);
//		System.out.println(Integer.parseInt(number));
//	}
}
