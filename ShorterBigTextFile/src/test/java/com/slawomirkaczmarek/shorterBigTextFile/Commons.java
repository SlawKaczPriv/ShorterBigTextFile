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
	
	/**
	 * 
	 * @param textFilePath
	 * @param megaByteSize
	 * @throws Exception
	 */
	static void createTextFile(Path textFilePath, int megaByteSize) throws Exception {
		
		if(megaByteSize < 1) {
			throw new IllegalArgumentException("megaByteSize < 1 ");
		}
		
		long destinationSize = megaByteSize * MegaByte.ONE_MEGA_BYTES;
		
		if(Files.exists(textFilePath)) {
			long existingFileSize = Files.size(textFilePath);
			if(existingFileSize == destinationSize) {
				return;
			}else {
				Files.delete(textFilePath);}
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(textFilePath.toString()))){
			for(long i = 0; i < destinationSize; i++) {
				bw.write("a");
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
