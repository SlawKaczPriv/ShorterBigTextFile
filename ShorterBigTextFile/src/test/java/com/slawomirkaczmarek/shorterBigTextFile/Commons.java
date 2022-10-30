package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Commons {

	static final Path BIG_TEXT_FILE_PATH = Paths.get("src/test/resources/bigTextFile.txt");

	static void createBigTextFile(Path bigTextFilePath) throws Exception {
		
		if(! Files.exists(bigTextFilePath)) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(bigTextFilePath.toString()))){
				System.out.println("JUnit Tests - BeforeAll - Creating BigTextFile");
				for(long i = 1; i < 80_000_001; i++) {
					bw.write("Line " + i);
					bw.newLine();
				}
			}
		}
	}
}
