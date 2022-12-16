package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Commons {
	
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
		
		long destinationSize = megaByteSize * Byte.ONE_MEGA_BYTES.longVal();
		
		if(Files.exists(textFilePath)) {
			long existingFileSize = Files.size(textFilePath);
			if(existingFileSize == destinationSize) {
				return;
			}else {
				Files.delete(textFilePath);}
		}
		
		try(FileWriter fW = new FileWriter(textFilePath.toString());
				BufferedWriter bw = new BufferedWriter(fW)){
			for(long i = 0; i < destinationSize; i++) {
				bw.write("a");
			}
			fW.close();
			bw.close();
		}
	}

	/**
	 * 
	 * @param shortTextFilePath
	 * @param info
	 */
	public static void deleteIfExists(Path shortTextFilePath, String info) {
		
		info = info.trim();
		info = info.length() > 0 ? info + " " : "";
		
		if(Files.exists(shortTextFilePath)) {
			try {
				Files.delete(shortTextFilePath);
				System.out.println(info + "Deleted file: " + shortTextFilePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
//			System.out.println(info + "deleteIfExists(): file not exists: " + shortTextFilePath);
		}
	}

	/**
	 * 
	 * @param shortTextFilePath
	 */
	public static void deleteIfExists(Path shortTextFilePath) {
		deleteIfExists(shortTextFilePath, "");
	}
}
