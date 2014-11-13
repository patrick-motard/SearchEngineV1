
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
	
		
		return Identifiers;
	
	}
	
	
	public static void store (ArrayList<String> list){
		for (String id:list){
			LinkedListObject idListObject = new LinkedListObject(id, )
		}
		
	}

}
