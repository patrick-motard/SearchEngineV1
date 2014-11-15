package org.uiowa.cs2820.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// This class creates the file storage for keys and values
class FileInitializer {
	protected static void KeyValueStorage(File file) {
		LinkedListObject LLObject = new LinkedListObject(null,-1,0);
		byte[] bytes = Utility.convert(LLObject);
		bytes = Utility.appendSize(bytes);
		RandomAccessFile writeFile;
		try {
			writeFile = new RandomAccessFile(file, "w");
			writeFile.write(bytes, 0, 1024);
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("FileInitializer: File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("FileInitializer: IOException");
		}
		
	}
}
