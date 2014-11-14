
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage {
	
<<<<<<< HEAD
	//public static int head;
	//public static int size;
	//public static long tail;
	//public String identifier;
	LinearFileDatabase db = null;
	DiskSpace disk = new DiskSpace("keyvalue");
	
	public ValueStorage(LinearFileDatabase db) {
		this.db = db;
	}

	public ArrayList<String> load(int front) throws IOException{
		ArrayList<String> Identifiers = new ArrayList<String>();
		//byte[] fileName = DiskSpace.readArea(front);
		// front = location of first identifier on disk
		return Identifiers;
		boolean nextObject = true;
		ArrayList<LinkedListObject> objectList = new ArrayList<LinkedListObject>();
		while (nextObject) {
			LinkedListObject myObject = Utility.readObject(front,disk);
			// myObject should be a LinkedListObject with a pointer to next LinkedListObject
			objectList.add(myObject);
			if (myObject.next == -1) {
				nextObject = false;
			}
			else {
				front = myObject.next;
			}
		}
		for (LinkedListObject myLinkedListObject : objectList) {
			String id = (String)myLinkedListObject.getObject();
			Identifiers.add(id);
		}
		// Use getObject and cast to a string to get strings
		// put all strings in arraylist
		// return arraylist
=======
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
>>>>>>> origin/master
		
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
<<<<<<< HEAD
		ArrayList<Integer> memorySpaces = this.db.allocator.allocate(list.size());
		ArrayList<LinkedListObject> LinkedListObjectArray = new ArrayList<LinkedListObject>();
		for (String id:list) {
			int mySpace = memorySpaces.remove(0);
			int nextSpace;
			if (memorySpaces.isEmpty() == false) {
				nextSpace = memorySpaces.get(0);
			}
			else {
				nextSpace = -1; // -1 = end of the list
			}
			
			LinkedListObject idListObject = new LinkedListObject(id,nextSpace,mySpace);
			LinkedListObjectArray.add(idListObject);
		}
		
		// Serialize each LinkedListObject using Utility class
		//byte[] bytes = Utility.convert(exampleLinkedListObject);
		
		// After all LinkedListObjects are converted to byte arrays
		// Use Utility.appendSize to store byte[] size inside each byte[]
=======
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
>>>>>>> origin/master
		
		// Use diskspace writeArea method to write each byte array to disk
		// disk.writeArea()
	}

}
