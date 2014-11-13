package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class AllocateTest {
	//each time we run the test will create new file, therefore we need to delete the previous
	//one, so that we keep Unit test independently
	@Before
	public void deletion(){
		File file = new File("test1.txt");
		file.delete();
	}
	//main test
	@Test
	public void allocateTest(){
		Allocate al = new Allocate("test1.txt");
		//using allocate method to apply 10 spaces(chunks in diskspace) starting from the
		//first false value in BitSet.
		al.allocate(10);
		//for each BitSet we have size 64, after using 10 we have 64-10=54
		assertEquals(al.size(),54);
		//for testing the free method, given ArrayList[1,2]
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2));
		al.free(l);
		//check the size is 54+2=56
		assertEquals(al.size(),56);
		//check the starting point since we free 1 previous
		assertEquals(al.startingPoint(),1);
		//we now have 56 space left, then now we need more space says 58>56
		al.allocate(58);
		assertEquals(al.size(),62);
	}

}
