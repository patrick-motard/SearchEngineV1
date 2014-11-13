package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class AllocateTest {
	@Before
	public void deletion(){
		File file = new File("test1.txt");
		file.delete();
	}
	@Test
	public void allocateTest(){
		Allocate al = new Allocate("test1.txt");
		al.allocate(10);
		assertEquals(al.size(),54);
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2));
		al.free(l);
		assertEquals(al.size(),56);
		al.allocate(58);
		assertEquals(al.size(),62);
	}

}
