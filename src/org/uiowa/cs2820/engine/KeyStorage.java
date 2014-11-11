// Chris Grycki
// Team 7
package org.uiowa.cs2820.engine;
import java.util.ArrayList;

// KeyStorage is utilized by LinearMemoryDatabase to store and retrieve 
// nodes.
public class KeyStorage {
	LinearFileDatabase db = null;
	DiskSpace disk = new DiskSpace("KeyStore");
	// Initializer takes a database to be used with the KeyStorage
	// method calls
	public KeyStorage(LinearFileDatabase db) {
		this.db = db;
	}
	
	// get - This is used exclusively by this class
	// 		 to retrieve a node at the location specified
	// 		 by areaNum
	private Node get(int areaNum) {
		// Find the node at areaNum and return it
		byte[] bytes = disk.readArea(areaNum);
		Object returnObject = Field.revert(bytes);
		if (returnObject != null) {
			Node returnNode = (Node)Field.revert(bytes);
			return returnNode;
		}
		else { return null; }
	}
	// put - This is used exclusively by this class 
	// 		 to add a Node into storage
	private void put(int areaNum, Node givenNode) {
		// Insert the given node at areaNum
		byte[] bytes = Field.convert(givenNode);
		disk.writeArea(areaNum,bytes);
	}
	// add - LinearFileDatabase calls this method to add the
	//		 the given node into storage
	public void add(Node givenNode) {
		// Use allocate to find a place to put
		// the given node
		int areaNum = db.allocator.allocate();
		put(areaNum, givenNode);
		
	}
	// del - LinearFileDatabase calls this method to remove the
	//		 given node from storage
	public void del(Node givenNode) {
		// Find the given node and use
		// allocate to free it
		int index = 0;
		Node nodeFound = get(index++);
		while(nodeFound != null) {
			if (nodeFound.Key == givenNode.Key) {
				db.allocator.free(index);
				break;
			}
			nodeFound = get(index++);
		}
	}
	// getList - Used exclusively for JUnit testing
	protected ArrayList<Node> getList(){
		ArrayList<Node> nodeList = new ArrayList<Node>();
		int index = 0;
		Node nodeFound = get(index++);
		while(nodeFound != null) {
			nodeList.add(nodeFound);
			nodeFound = get(index++);
		}
		return nodeList;
	}

}
