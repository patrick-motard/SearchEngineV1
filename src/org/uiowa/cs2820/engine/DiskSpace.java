// -- Patrick Motard -- //

package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class DiskSpace {

	private static File file = new File("DiskSpace.txt");

	public DiskSpace(String fileName) {
	}

	public static void writeArea(int areaNum, byte[] b) throws IOException {
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

	public static byte[] readArea(int areaNum) throws IOException {

		RandomAccessFile readfile = new RandomAccessFile(file, "r");
		readfile.seek(areaNum);
		byte[] bytes = new byte[1024];
		readfile.read(bytes);
		readfile.close();
		return bytes;
	}

}