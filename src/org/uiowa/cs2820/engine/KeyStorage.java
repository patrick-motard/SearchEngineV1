// Chris Grycki
// Team 7
package org.uiowa.cs2820.engine;
import java.util.ArrayList;
import java.io.*;

// KeyStorage is utilized by LinearMemoryDatabase to store and retrieve 
// nodes.
public class KeyStorage {
	

	String fileName;
	LinearFileDatabase db;
	DiskSpace disk;
	Allocate allocator;
	// Initializer takes a database to be used with the KeyStorage
	// method calls
	public KeyStorage(LinearFileDatabase db, String fileName) {
		this.db = db;
		this.fileName = fileName;
		this.disk = new DiskSpace(fileName);
		this.allocator = new Allocate(fileName);
	}
	
	// get - This is used to retrieve a node at the location specified
	// 		 by areaNum
	public Node get(int areaNum) throws IOException {
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
	public void put(int areaNum, Node givenNode) throws IOException {
		// Update the tail of the linked list
		LinkedListObject tail = getLast();
		tail.setNext(areaNum);
		byte[] bytes = Utility.convert(tail);
		disk.writeArea(tail.getSelf(), bytes);
		// Insert the given node at areaNum
		LinkedListObject nodeNext = new LinkedListObject(givenNode,-1,areaNum);
		bytes = Utility.convert(nodeNext);
		disk.writeArea(areaNum,bytes);
	}
	
	// add - LinearFileDatabase calls this method to add the
	//		 the given node into storage
	public void add(Node givenNode) throws IOException {
		// Use allocate to find a place to put
		// the given node
		int areaNum = allocator.allocate(1).get(0);
		put(areaNum, givenNode);
		
	}
	
	// del - LinearFileDatabase calls this method to remove the
	//		 given node from storage
	public void del(Node givenNode) throws IOException {
		// Find the given node and use
		// allocate to free it
		// int index = 0;
		byte[] bytes = disk.readArea(0);
		LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
		LinkedListObject prevNodeNext = nodeNext;
		while(nodeNext.getNext() != -1) {
			if ( ((Node)(nodeNext.getObject())).Key == givenNode.Key) {
				prevNodeNext.setNext(nodeNext.getNext());
				allocator.free(new ArrayList<Integer>(nodeNext.getSelf()));
				bytes = Utility.convert(prevNodeNext);
				disk.writeArea(prevNodeNext.getSelf(), bytes);
				break;
			}
			prevNodeNext = nodeNext;
			bytes = disk.readArea(nodeNext.getNext());
			nodeNext = (LinkedListObject)Utility.revert(bytes);
			
		}
	}
	
	// getList - Used exclusively for JUnit testing
	protected ArrayList<Node> getList() throws IOException{
		ArrayList<Node> nodeList = new ArrayList<Node>();
		byte[] bytes = disk.readArea(0);
		LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
		while (nodeNext.getNext() != -1) {
			nodeList.add((Node)nodeNext.getObject());
			bytes = disk.readArea(nodeNext.getNext());
			nodeNext = (LinkedListObject)Utility.revert(bytes);
		}
		
		return nodeList;
	}
	
	// getLast - Returns the tail of the Linked List of nodes
	private LinkedListObject getLast() throws IOException {
		byte[] bytes = disk.readArea(0);
		LinkedListObject nodeNext = (LinkedListObject)Utility.revert(bytes);
		while (nodeNext.getNext() != -1 ) {
			bytes = disk.readArea(nodeNext.getNext());
			nodeNext = (LinkedListObject)Utility.revert(bytes);
		}
		return nodeNext;
		
	}

}
