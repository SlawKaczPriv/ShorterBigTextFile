package com.slawomirkaczmarek.shorterBigTextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
class SourceFile {

	private final Path path;
	private final boolean exists;
	private final long size;

	/**
	 * 
	 * @param path
	 */
	SourceFile(Path path) {
		
		this.path = path;
		this.exists = exists(path);
		this.size = size(path);
	}

	private boolean exists(Path path) {
		
		try {
			if(Files.exists(path)) {
				return true;
			}else {
				return false;}
		}catch (SecurityException e) {
			System.out.println("EXCEPTION from SourceFile Files.exists(): " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	boolean exists() {
		return exists;
	}
	
	private long size(Path path) {
		
		try {
			return Files.size(path);
		}catch (Exception e) {
			System.out.println("EXCEPTION from SourceFile Files.size(): " + e.getMessage());
			return -1;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	long getSize() {
		return size;
	}

	/**
	 * 
	 * @param destinationFilePath
	 * @param destinationFileSize
	 * 
	 * @return true if success otherwise false.
	 */
	boolean shortenTo(Path destinationFilePath, FileSize destinationFileSize) {
		
		int newShorterTextFileSize = (int) destinationFileSize.bytes();
		
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
