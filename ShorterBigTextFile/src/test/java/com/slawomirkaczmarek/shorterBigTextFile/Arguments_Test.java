package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class Arguments_Test {

	@Test
	void Arguments_test_IllegalArgumentException() throws Exception {
		
		// Given
		String[] args = new String[] {
				"bla",
				"blabla"
			};
		
		// Then
		assertThrows(IllegalArgumentException.class, () -> {
			new Arguments(args);
		});
	}

	@Test
	final void Arguments_test_Successfully() throws Exception {
		
		// Given
		String[] args = new String[] {"source", "dest", "2.9"};
		Arguments actualArguments = new Arguments(args);
		
		Path expectedSource = Paths.get("source");
		Path expectedDest = Paths.get("dest");
		MegaByte expectedMegaBytes = new MegaByte("2.9");
		
		// Then
		assertTrue(actualArguments.isSuccessfullyInitialized());
		assertEquals(expectedSource, actualArguments.sourceFilePath);
		assertEquals(expectedDest, actualArguments.destinationFilePath);
		assertEquals(expectedMegaBytes, actualArguments.megaBytes);
	}

	// Edge case
	@Test
	final void test_destinationFileSizeMaxValue() throws Exception {
		
		// Given
		BigDecimal maxValue = MegaByte.MAX_VALUE.getValue();
		String[] args = new String[] {"source", "dest", String.valueOf(maxValue)};
		Arguments actualArguments = new Arguments(args);
		
		Path expectedSource = Paths.get("source");
		Path expectedDest = Paths.get("dest");
		MegaByte expectedMegaBytes = new MegaByte(String.valueOf(MegaByte.MAX_VALUE.getValue()));
//		System.out.println(megaBytes);
		
		// Then
		assertTrue(actualArguments.isSuccessfullyInitialized());
		assertEquals(expectedSource, actualArguments.sourceFilePath);
		assertEquals(expectedDest, actualArguments.destinationFilePath);
		assertEquals(expectedMegaBytes, actualArguments.megaBytes);
	}

	// Edge case
	@Test
	final void test_destinationFileSizeMoreThanMaxValue() throws Exception {
		
		// Given
		BigDecimal moreThanMaxValue = MegaByte.MAX_VALUE.getValue().add(new BigDecimal(0.000_000_000_000_000_000_001));
		String[] args = new String[] {"source", "dest", String.valueOf(moreThanMaxValue)};
		Arguments actualArguments = new Arguments(args);
		
		Path expectedSource = Paths.get("source");
		Path expectedDest = Paths.get("dest");
		MegaByte expectedMegaBytes = new MegaByte("0");
		
		// Then
		assertFalse(actualArguments.isSuccessfullyInitialized());
		assertEquals(expectedSource, actualArguments.sourceFilePath);
		assertEquals(expectedDest, actualArguments.destinationFilePath);
		assertEquals(expectedMegaBytes, actualArguments.megaBytes);
	}

//	Edge case
	@Test
	final void test_destinationFileSizeMinValue() throws Exception {
		
		// Given
		BigDecimal minValue = MegaByte.MIN_VALUE.getValue();
		String[] args = new String[] {"source", "dest", String.valueOf(minValue)};
		Arguments actualArguments = new Arguments(args);
		
		Path expectedSource = Paths.get("source");
		Path expectedDest = Paths.get("dest");
		MegaByte expectedMegaBytes = new MegaByte("0");
		
		// Then
		assertTrue(actualArguments.isSuccessfullyInitialized());
		assertEquals(expectedSource, actualArguments.sourceFilePath);
		assertEquals(expectedDest, actualArguments.destinationFilePath);
		assertEquals(expectedMegaBytes, actualArguments.megaBytes);
	}

//	Edge case
	@Test
	final void test_destinationFileSizeLessThanMinValue() throws Exception {
		
		// Given
		BigDecimal lessThanMegaByteMinValue = MegaByte.MIN_VALUE.getValue().subtract(new BigDecimal(0.000_000_000_000_000_000_001));
		String[] args = new String[] {"source", "dest", String.valueOf(lessThanMegaByteMinValue)};
		Arguments actualArguments = new Arguments(args);
		
		Path expectedSource = Paths.get("source");
		Path expectedDest = Paths.get("dest");
		MegaByte expectedMegaBytes = new MegaByte("0");
		
		// Then
		assertFalse(actualArguments.isSuccessfullyInitialized());
		assertEquals(expectedSource, actualArguments.sourceFilePath);
		assertEquals(expectedDest, actualArguments.destinationFilePath);
		assertEquals(expectedMegaBytes, actualArguments.megaBytes);
	}
	@Test
	final void test_destinationFileSizeLess_NumberFormatException() throws Exception {
		
		// Given
		String[] args = new String[] {"source", "dest", "ela"};
		Arguments actualArguments = new Arguments(args);
		
		Path expectedSource = Paths.get("source");
		Path expectedDest = Paths.get("dest");
		MegaByte expectedMegaBytes = new MegaByte("0");
		
		// Then
		assertFalse(actualArguments.isSuccessfullyInitialized());
		assertEquals(expectedSource, actualArguments.sourceFilePath);
		assertEquals(expectedDest, actualArguments.destinationFilePath);
		assertEquals(expectedMegaBytes, actualArguments.megaBytes);
	}
}
