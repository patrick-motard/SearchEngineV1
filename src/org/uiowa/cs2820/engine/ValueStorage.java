
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage {
	
	LinearFileDatabase db = null;
	DiskSpace disk = new DiskSpace("keyvalues");
	
	
	public ValueStorage(LinearFileDatabase db){
		this.db = db;
		
	}
	
	public static ArrayList<String> load(long front) throws IOException{
		ArrayList<String> Identifiers = new ArrayList<String>();
		byte[] filenae = DiskSpace.readArea(front);
	
		
		return Identifiers;
	
	}
	
	
	public void store (ArrayList<String> list){
		// Call allocator with number of LinkedListObjects
		ArrayList<Integer> MemorySpaces = this.db.allocator.allocate(list.size());
		ArrayList<LinkedListObject> LinkedListObjectArray = new ArrayList<LinkedListObject>();
		
		for (String id:list){
			int mySpace = memorySpaces.get(0);
			if (memeorySpaces.isEmpty() == false){
				int nextSpace = memeorySpaces.get(0);
			
			}
			else{
				int nextSpace = -1; // -1 = end of the list
			}
			LinkedListObject idListObject = new LinkedListObject(id, )
		}
		
	}

}
