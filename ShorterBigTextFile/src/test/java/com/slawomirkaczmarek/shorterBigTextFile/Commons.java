package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Commons {

	/** BigTextFile size = 1 188 888 897 bytes (1.10 GB) */
	static final Path BIG_TEXT_FILE_PATH = Paths.get("src/test/resources/bigTextFile.txt");

	/**
	 * BigTextFile size = 1 188 888 897 bytes (1.10 GB)
	 * 
	 * @param bigTextFilePath
	 * @throws Exception
	 */
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

	public static void deleteIfExists(Path shortTextFilePath, String info) {
		
		if(Files.exists(shortTextFilePath)) {
			try {
				Files.delete(shortTextFilePath);
				System.out.println(info + ". Deleted file: " + shortTextFilePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
