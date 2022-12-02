package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
		this.size = fileSize(path);
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

//	/**
//	 * MAIN FUNCTIONALITY of application.
//	 * 
//	 * @param destinationFilePath
//	 * @param destinationFileSize more or equal zero
//	 * 
//	 * @return true if success otherwise false.
//	 * @throws IOException 
//	 */
	/**
	 * MAIN FUNCTIONALITY of application.
	 * 
	 * @param destinationFilePath
	 * @param destinationFileSize
	 * 
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public void shortenTo(Path destinationFilePath, int destinationFileSize) throws IllegalArgumentException, IOException {
		
		if(destinationFileSize < 0) {
			throw new IllegalArgumentException("destinationFileSize value: " + destinationFileSize);
		}
		
		try(FileChannel sourceFileFCh = (FileChannel) Files.newByteChannel(this.path);
				BufferedWriter destinationFile = new BufferedWriter(new FileWriter(destinationFilePath.toString()))){
			
			MappedByteBuffer sourceFileMBuf = sourceFileFCh.map(FileChannel.MapMode.READ_ONLY, 0, sourceFileFCh.size());
			int sourceFileMBufLlimit = sourceFileMBuf.limit();
			
			if(destinationFileSize >= sourceFileMBufLlimit) {
				throw new IllegalArgumentException("destinationFileSize value: " + destinationFileSize
						+ ", sourceFileMappedByteBuffer.limit: " + sourceFileMBufLlimit);
			}
			
			byte character;
			for(int i = sourceFileMBufLlimit - destinationFileSize; i < sourceFileMBuf.limit(); i++) {
				character = sourceFileMBuf.get(i);
				destinationFile.write(character);
			}
		}//catch (Exception e) {
//			System.out.println("EXCEPTION from SourceFile.shortenTo(): " + e.getMessage());
//		}
	}
}
