package org.uiowa.cs2820.engine;

import java.util.ArrayList;
import java.util.BitSet;

public class Allocate {

	private CheckPoint cp = null;

	// constructor of Allocate
	public Allocate(String fileName) {
		this.cp = new CheckPoint(fileName);
	}

	// method allocate will take a integer(the space size to save data) from keyStorage or valueStorage
	// as parameter and return an ArrayList of integer of valid position

	public ArrayList<Integer> allocate(int size) {
		ArrayList<Integer> position = new ArrayList<Integer>();
		BitSet bs = null;
    //check the file first time 
		if (cp.isExists()) {
			bs = (BitSet) cp.restore();
		} else {
			bs = new BitSet(size);
		}
		int init = 0;
		while (position.size() < size) {

			init = bs.nextClearBit(init);
			bs.set(init);
			position.add(init);
		}
		cp.save(bs);
		return position;
	}
    //take an ArrayList as parameter, the integer in ArrayList indicates 
	//the position will be released
	public void free(ArrayList<Integer> position) {
		BitSet bs = (BitSet) cp.restore();
		for (Integer i : position)
			bs.clear(i);
		cp.save(bs);
	}
	//supporting method 
    //return the number of "false" in BitSet  
	public int size() {
		BitSet bs = (BitSet) cp.restore();
		return bs.size() - bs.cardinality();
	}
	//supporting method 
	public int startingPoint(){
		BitSet bs = (BitSet) cp.restore();
		return bs.nextClearBit(0);
	}
	
}
