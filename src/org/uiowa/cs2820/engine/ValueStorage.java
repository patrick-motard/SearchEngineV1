
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage {
	
	LinearFileDatabase db = null;
	DiskSpace disk = new DiskSpace("keyvalues");
	
	
	public ValueStorage(LinearFileDatabase db){
		this.db = db;
		
	}
	
	private LinkeListObject readObject(int front){
		
		int size;
		LinkedListObject returnObject = null;
		byte[] allBytes = disk.readArea(front);
		byte[] sizeBytes = Arrays.copyOfRange(allBytes, 0, 2);
		size = ((sizeBytes[0] & 0xff) << 8) + (sizeBytes[1] & 0xff);
		
		return returnObject;
		
	}
	
	
	public static ArrayList<String> load(int front) throws IOException{
		ArrayList<String> Identifiers = new ArrayList<String>();
		//byte[] filename = DiskSpace.readArea(front);
		
		boolean nextObject = true;
		ArrayList<LinkedListObject> objectList = new ArrayList<LinkedListObject>();
		while (nextObject){
			LinkedListObject myObject = readObject (front);
			objectlist.add(myObject);
			if(myObject.next == -1){
				nextObject = false;
			}
			else {
				front = myObject.next;
			}
		}
	
	}
	
	
	public void store (ArrayList<String> list){
		// Call allocator with number of LinkedListObjects
		ArrayList<Integer> MemorySpaces = this.db.allocator.allocate(list.size());
		ArrayList<LinkedListObject> LinkedListObjectArray = new ArrayList<LinkedListObject>();
		
		for (String id:list){
			int mySpace = memorySpaces.get(0);
			if (memeorySpaces.isEmpty() == false){
				nextSpace = memeorySpaces.get(0);
			
			}
			else{
				nextSpace = -1; // -1 = end of the list
			}
			LinkedListObject idListObject = new LinkedListObject(id, )
		}
		
	}

}
