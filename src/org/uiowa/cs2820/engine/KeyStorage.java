// Chris Grycki
// Team 7
package org.uiowa.cs2820.engine;

// KeyStorage is utilized by LinearFileDatabase to store and retrieve 
// nodes.
public class KeyStorage {
	
	// get - This is used exclusively by this class
	// 		 to retrieve a node at the location specified
	// 		 by areaNum
	private Node get(int areaNum) {
		// Find the node at areaNum and return it
		Node returnNode = new Node(null, null);
		return returnNode;
	}
	// put - This is used exclusively by this class 
	// 		 to add a Node into storage
	private void put(int areaNum, Node givenNode) {
		// Insert the given node at areaNum
		
	}
	// add - LinearFileDatabase calls this method to add the
	//		 the given node into storage
	public void add(Node givenNode) {
		// Use allocate to find a place to put
		// the given node
	}
	// del - LinearFileDatabase calls this method to remove the
	//		 given node from storage
	public void del(Node givenNode) {
		// Find the given node and use
		// allocate to free it
	}
}
