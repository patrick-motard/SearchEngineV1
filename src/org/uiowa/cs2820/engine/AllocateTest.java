package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AllocateTest {
	@Test
	public void allocateTest(){
		Allocate al = new Allocate("test1.txt");
		al.allocate(10);
		assertEquals(al.size(),54);
	}

}
