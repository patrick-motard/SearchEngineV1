package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class CheckpointTest {
	//delete the file created before using same name so that keeps the
	//unit test independently
	@Before
	public void deletion(){
		File file = new File("test1.txt");
		file.delete();
	}
	//main test
	@Test
	public void saveTest(){
		CheckPoint cp = new CheckPoint("test1.txt");
		cp.save("1234");
		assertEquals(cp.restore(),"1234");
		CheckPoint cp1 = new CheckPoint("test2.txt");
		String s="abcdefg";
		cp1.save(s);
		assertEquals(cp1.restore(),"abcdefg");
	}

}
