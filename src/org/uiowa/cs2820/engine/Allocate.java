package org.uiowa.cs2820.engine;

public class Allocate {
	int index = 0;
	// Initializer
	protected Allocate() {
		
	}
	// allocate - Find a free space in memory and return
	//			  the location of it.
	protected int allocate() {
		return index++;
	}
	// free - Take the location of an area in memory and
	//		  mark it as free.
	protected void free(int areaNum) {
		
	}
}
