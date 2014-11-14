// -- Patrick Motard -- //

package org.uiowa.cs2820.engine;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;


public class DiskSpace {
	public static void writeArea(String information, int location) throws IOException{
		String path = "disc.txt";
		File file = new File(path);
		if (!file.exists()) {
				file.createNewFile();
				System.out.println("new file created");
			}
		RandomAccessFile RAfile = new RandomAccessFile(file,"rw");
		RAfile.seek(location);
		RAfile.write(information.getBytes());
		RAfile.close();
	}
	
	public static byte[] readArea(int location, int size) throws IOException{
		String filepath = "disc.txt";
		File file = new File(filepath);
		RandomAccessFile RAfile = new RandomAccessFile(file,"r"); 
		RAfile.seek(location); 										
		byte[] data = new byte[size];	
		RAfile.read(data);
		RAfile.close();
		return data;
	}
}