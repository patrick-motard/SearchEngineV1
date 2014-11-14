package org.uiowa.cs2820.engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Utility {
	public static byte[] convert(Object O) {
	  // private method converts objects into byte array
	  ByteArrayOutputStream M = new ByteArrayOutputStream();
	  ObjectOutput N = null;
	  try {
		N = new ObjectOutputStream(M);
		N.writeObject(O);
	    } 
	  catch (IOException e) {
	    return null; // wrong, but should not happen	    	
	    }
	  return M.toByteArray();
	  }
		
	public static Object revert(byte[] seq) {
	  Object O = null;  // default value
	  try {
		ByteArrayInputStream M = new ByteArrayInputStream(seq);
		ObjectInputStream N = new ObjectInputStream(M);
		O = N.readObject();
		}
	  catch (Exception e) { };
		return O;
	  }
	public static LinkedListObject readObject(int areaNum,DiskSpace disk) {
		// Call diskspace readArea method with front - disk.readArea(front)
		// first 2 bytes in byte array tell us how many bytes to read
		// ex: 0000 0000 0000 0101 = 5 bytes
		// whatwewant = byteArray[0:4]
		// Use utility class on byte array to get object
		
		LinkedListObject returnObject = null;
		byte[] allBytes = disk.readArea(areaNum);
		byte[] sizeBytes = Arrays.copyOfRange(allBytes, 0, 2);
		int size = ((sizeBytes[0] & 0xff) << 8) + (sizeBytes[1] & 0xff);
		byte[] objectBytes = Arrays.copyOfRange(allBytes, 2, size+1);
		returnObject = (LinkedListObject)Utility.revert(objectBytes);
		return returnObject;
		
	}
	
	public static byte[] appendSize(byte[] data) {
		// get size of each byte array
		// In beginning of each bye array, store size in 2 bytes 
		byte[] returnBytes = null;
		return returnBytes;
	}
}
