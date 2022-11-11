package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */
class AppProperties {
	
	private boolean successfullyInitialized;

	final Path bigTextFilePath;
	final Path shorterTextFilePath;
	final FileSize shorterTextFileSize;

	/**
	 * 
	 * @param args
	 */
	AppProperties(String[] args) {
		
		this.successfullyInitialized = true;
		
		this.bigTextFilePath = bigTextFilePath(args);
		this.shorterTextFilePath = shorterTextFilePath(args);
		this.shorterTextFileSize = newShorterTextFileSize(args);
	}

	private Path bigTextFilePath(String[] args) {
		
		try {
			return Paths.get(args[0]);
		}catch (Exception e) {
			System.out.println("ERROR bigTextFilePath. Message: "
					+ e.getMessage());
			this.successfullyInitialized = false;
			return Paths.get("");
		}
	}

	private Path shorterTextFilePath(String[] args) {
		
		try {
			return Paths.get(args[1]);
		}catch (Exception e) {
			System.out.println("ERROR shorterTextFilePath. Message: "
					+ e.getMessage());
			this.successfullyInitialized = false;
			return Paths.get("");
		}
	}

	private FileSize newShorterTextFileSize(String[] args) {
		
		if(args.length == 3) {
			try {
				int size = Integer.parseInt(args[2]);
				this.successfullyInitialized = true;
				return new FileSize(size * FileSize.ONE_MEGA_BYTES);
			}catch (Exception e) {
				System.out.println("ERROR Property size of NewShorterTextFile is not valid. Message: "
						+ e.getMessage());
				this.successfullyInitialized = false;
				return new FileSize(-1 * FileSize.ONE_MEGA_BYTES);
			}
		}else {
			if(this.successfullyInitialized) {
				FileSize result = new FileSize(FileSize.DEFAULT_SIZE);
				System.out.println("Property NewShorterTextFileSize is set as default: "
						+ result.megaBytes() + " MB.");
				return result;
			}else {
				return new FileSize(-1 * FileSize.ONE_MEGA_BYTES);
			}
		}
	}

	@Override
	public String toString() {
		
		return new StringBuilder()
				.append("bigTextFilePath=").append(bigTextFilePath)
				.append(" newShorterTextFilePath=").append(shorterTextFilePath)
				.append(" newShorterTextFileSize=").append(shorterTextFileSize.megaBytes()).append(" MB")
				.toString();
	}

	/**
	 * 
	 * @return
	 */
	boolean isSuccessfullyInitialized() {
		return successfullyInitialized;
	}
}
