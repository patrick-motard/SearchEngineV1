

package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage {
	
	public static int head;
	public static int size;
	public sattic long tail;
	public String identifier;
	
	public static ArrayList<String> load(long front) throws IOException{
		ArrayList<String> Identifiers = new ArrayList<String>();
		byte[] fileName = DiskSpace.read(front);
		
		
		return Identifiers;
	
	}
	
	
	public static void store (ArrayList<String> list){
		
	}

}
