package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The Class with MAIN FUNCTIONALITY of application.
 */
class SourceFile extends File {
	
	/**
	 * 
	 * @param path
	 */
	SourceFile(Path path) {
		
		super(path);
		this.fileSize = fileSize(path);
	}

	private Byte fileSize(Path path) {
		
		if(! this.exists) {
			return new Byte(0);
		}
		
		try {
			long size = Files.size(path);
			return new Byte(size);
		}catch (Exception e) {
			System.out.println("EXCEPTION from SourceFile Files.size(): " + e.getMessage());
			return new Byte(0);
		}
	}

	/**
	 * MAIN FUNCTIONALITY of application.
	 * 
	 * @param destinationFilePath
	 * @param destinationFileSize
	 * 
	 * @return true if success otherwise false.
	 */
	public boolean shortenTo(Path destinationFilePath, long destinationFileSize) {
		
		int newShorterTextFileSize = (int) destinationFileSize;
		
		try(FileChannel fChan = (FileChannel) Files.newByteChannel(this.path);
				BufferedWriter bufferdWriter = new BufferedWriter(new FileWriter(destinationFilePath.toString()))){
			
			MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fChan.size());
			byte character;
			for(int i = mBuf.limit() - newShorterTextFileSize; i < mBuf.limit(); i++) {
				character = mBuf.get(i);
				bufferdWriter.write(character);
			}
			return true;
		}catch (Exception e) {
			System.out.println("EXCEPTION from SourceFile.shortenTo(): " + e.getMessage());
			return false;
		}
	}
}
