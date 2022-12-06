package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */
abstract class File {

	final Path path;
	final boolean exists;
	protected Byte size;
	
	/**
	 * 
	 * @param path
	 */
	File(Path path) {
		
		this.path = path;
		this.exists = exists(path);
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

	/**
	 * 
	 * @return
	 */
	Byte getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "SourceFile [path=" + path + ", exists=" + exists + ", size=" + size.longVal() + " bytes]";
	}
}
