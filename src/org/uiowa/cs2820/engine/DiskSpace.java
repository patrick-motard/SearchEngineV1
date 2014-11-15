// -- Patrick Motard -- //

package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class DiskSpace {

	private static File file = null;

	public DiskSpace(String fileName) {
		file = new File(fileName);
		if (! file.exists()) { // If the file does not exist
			FileInitializer.KeyValueStorage(file);
		}
		
	}

	public void writeArea(int areaNum, byte[] b) throws IOException {
		if (file.exists()) {
			RandomAccessFile writefile = new RandomAccessFile(file, "rw");
			writefile.seek(areaNum);
			// writefile.setLength(1024);
			writefile.write(b);
			writefile.close();
		} else {
			RandomAccessFile writefile = new RandomAccessFile("DiskSpace.txt",
					"rw");
			writefile.seek(areaNum);
			// writefile.setLength(1024);
			writefile.write(b);
			writefile.close();
		}
	}

	public byte[] readArea(int areaNum) throws IOException {

		RandomAccessFile readfile = new RandomAccessFile(file, "r");
		readfile.seek(areaNum);
		byte[] bytes = new byte[1024];
		readfile.read(bytes);
		readfile.close();
		return bytes;
	}

}