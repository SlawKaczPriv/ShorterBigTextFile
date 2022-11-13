package com.slawomirkaczmarek.shorterBigTextFile;

import java.nio.file.Path;

interface SourceFile {

	boolean exists();
	long getSize();
	boolean shortenTo(Path destinationFilePath, long destinationFileSize);
}
