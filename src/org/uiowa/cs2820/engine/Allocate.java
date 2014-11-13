package org.uiowa.cs2820.engine;

import java.util.ArrayList;
import java.util.BitSet;

public class Allocate {
	
	private CheckPoint cp = null;
	
	//constructor of Allocate 
	
	public Allocate(String fileName)
	{
		
		this.cp = new CheckPoint(fileName);
	}
	
    //method allocate will take a length(integer) from keyStorage or valueStorage
	//as parameter and return an ArrayList of integer of valid position to save data
	
	public ArrayList<Integer> allocate(int size, String filename) 
	{
		ArrayList<Integer> position = new ArrayList<Integer>();
		BitSet bs = null;
		if (cp.isExists())
		{
			
			bs = (BitSet) cp.restore(filename);
		} 
		else
		{
			
			bs = new BitSet(size);
		}
		int init = 0;
		while (position.size() < size)
		{
			
			init = bs.nextClearBit(init);
			bs.set(init);
			position.add(init);
		}
		cp.save(bs);
		return position;
	}
    //
	
	public void free(ArrayList<Integer> position, String filename) 
	{
		BitSet bs = (BitSet) cp.restore(filename);
 
		for (Integer i : position)
			bs.clear(i);
		
		cp.save(bs);
	}
}

