// Chris Grycki
// Team 7
package org.uiowa.cs2820.engine;
import java.util.ArrayList;
import java.io.*;

// KeyStorage is utilized by LinearMemoryDatabase to store and retrieve 
// nodes.
public class KeyStorage {
	

	
	LinearFileDatabase db = null;
	DiskSpace disk = new DiskSpace("Keyvalue");
	// Initializer takes a database to be used with the KeyStorage
	// method calls
	public KeyStorage(LinearFileDatabase db) {
		this.db = db;
		
	}
	
	// get - This is used to retrieve a node at the location specified
	// 		 by areaNum
	public Node get(int areaNum) {
		// Find the node at areaNum and return it
		byte[] bytes = disk.readArea(areaNum);
		Object returnObject = Utility.revert(bytes);
		if (returnObject != null) {
			LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
			return (Node)nodeNext.getObject();
		}
		else { return null; }
	}
	
	// put - This is used exclusively by this class 
	// 		 to add a Node into storage
	public void put(int areaNum, Node givenNode) {
		// Update the tail of the linked list
		LinkedListObject tail = getLast();
		tail.next = areaNum;
		byte[] bytes = Utility.convert(tail);
		disk.writeArea(tail.areaNum, bytes);
		// Insert the given node at areaNum
		LinkedListObject nodeNext = new LinkedListObject(givenNode,-1,areaNum);
		bytes = Utility.convert(nodeNext);
		disk.writeArea(areaNum,bytes);
	}
	
	// add - LinearFileDatabase calls this method to add the
	//		 the given node into storage
	public void add(Node givenNode) {
		// Use allocate to find a place to put
		// the given node
		int areaNum = db.allocator.allocate(1).get(0);
		put(areaNum, givenNode);
		
	}
	
	// del - LinearFileDatabase calls this method to remove the
	//		 given node from storage
	public void del(Node givenNode) {
		// Find the given node and use
		// allocate to free it
		int index = 0;
		byte[] bytes = disk.readArea(0);
		LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
		LinkedListObject prevNodeNext = nodeNext;
		while(nodeNext.next != -1) {
			if ( ((Node)(nodeNext.getObject())).Key == givenNode.Key) {
				prevNodeNext.next = nodeNext.next;
				db.allocator.free(new ArrayList<Integer>(nodeNext.areaNum));
				bytes = Utility.convert(prevNodeNext);
				disk.writeArea(prevNodeNext.areaNum, bytes);
				break;
			}
			prevNodeNext = nodeNext;
			bytes = disk.readArea(nodeNext.next);
			nodeNext = (LinkedListObject)Utility.revert(bytes);
			
		}
	}
	
	// getList - Used exclusively for JUnit testing
	protected ArrayList<Node> getList(){
		ArrayList<Node> nodeList = new ArrayList<Node>();
		byte[] bytes = disk.readArea(0);
		LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
		while (nodeNext.next != -1) {
			nodeList.add((Node)nodeNext.getObject());
			bytes = disk.readArea(nodeNext.next);
			nodeNext = (LinkedListObject)Utility.revert(bytes);
		}
		
		return nodeList;
	}
	
	// getLast - Returns the tail of the Linked List of nodes
	private LinkedListObject getLast() {
		byte[] bytes = disk.readArea(0);
		LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
		while (nodeNext.next != -1 ) {
			bytes = disk.readArea(nodeNext.next);
			nodeNext = (LinkedListObject)Utility.revert(bytes);
		}
		return nodeNext;
		
	}

}
