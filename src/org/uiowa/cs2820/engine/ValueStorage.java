
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage {
	
	LinearFileDatabase db = null;
	DiskSpace disk = new DiskSpace("keyvalues");
	Allocate allocator = new Allocate("keyvalues");
	
	public ValueStorage(LinearFileDatabase db){
		this.db = db;
		
	}

	public ArrayList<String> load(int front) throws IOException{
		ArrayList<String> Identifiers = new ArrayList<String>();
		
		boolean nextObject = true;
		ArrayList<LinkedListObject> objectList = new ArrayList<LinkedListObject>();
		while (nextObject) {
			LinkedListObject myObject = Utility.readObject(front,disk);
			// myObject should be a LinkedListObject with a pointer to next LinkedListObject
			objectList.add(myObject);
			if (myObject.getNext() == -1) {
				nextObject = false;
			}
			else {
				front = myObject.getNext();
			}
		}
		
		for (LinkedListObject myLinkedListObject : objectList) {
			String id = (String)myLinkedListObject.getObject();
			Identifiers.add(id);
		}
		return Identifiers;

	}

	public void store (ArrayList<String> list){
		
		// Call allocator with number of LinkedListObjects
		
		ArrayList<Integer> memorySpaces = this.allocator.allocate(list.size());
		
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
		
		ListIterator<LinkedListObject> listIterator = LinkedListObjectArray.listIterator();
		int i = 0;
		while(listIterator.hasNext()){
			byte[] bytes = Utility.convert(listIterator.next());
			Utility.appendSize(bytes);
			try{
				disk.writeArea(i++, bytes);
				
			}
			catch (IOException exception){
				System.out.println(exception);
			}
		
		}

	}

}
