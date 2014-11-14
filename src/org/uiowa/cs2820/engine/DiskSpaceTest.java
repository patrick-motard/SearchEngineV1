// -- Patrick Motard --//
package org.uiowa.cs2820.engine;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;


public class DiskSpaceTest {
	DiskSpace disk = new DiskSpace("newfile.txt");
	
	byte[] test = new byte[1024];
	@Test
	public void TestInit(){
		try {
			disk.writeArea(1,test);
		} catch (IOException exception) {
			System.out.println("test init failed");
			exception.printStackTrace();
			System.out.println(exception);
		}
		String path = "disc.txt";
		File file = new File(path);
		assertEquals(file.exists(),true);
	}
			
	@Test
	public void TestReadWrite() {
		byte[] expected = new byte[1024];
		try {
			disk.writeArea(1,expected);
		} catch (IOException exception) {
			System.out.println("Write Error");
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		byte[] actual = new byte[1024];
		try {
			actual = disk.readArea(1);
		} catch (IOException exception) {
			System.out.println("Read Error");
			exception.printStackTrace();
			System.out.println(exception);
		}

		assertArrayEquals(expected,actual);
	}
}