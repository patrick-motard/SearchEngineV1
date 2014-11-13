package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckpointTest {
	@Test
	public void saveTest(){
		CheckPoint cp = new CheckPoint("test1.txt");
		cp.save("1234");
		//assertEquals(cp.isExists(),true);
		//cp.restore("test1.txt");
		assertEquals(cp.restore(),"1234");
		
		CheckPoint cp1 = new CheckPoint("test2.txt");
		
	}

}
