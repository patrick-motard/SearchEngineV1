// -- Patrick Motard --//
package org.uiowa.cs2820.engine;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;


public class DiskSpaceTest {
	@Test
	public void TestInit(){
		try {
			DiskSpace.writeArea("atest", 50);
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
		byte[] test = null;
		try {
			DiskSpace.writeArea("tester", 0);
		} catch (IOException exception) {
			System.out.println("Write Error");
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		try {
			test = DiskSpace.readArea(0,6);
		} catch (IOException exception) {
			System.out.println("Read Error");
			exception.printStackTrace();
			System.out.println(exception);
		}

		assertEquals(test.length,6);
	}
}