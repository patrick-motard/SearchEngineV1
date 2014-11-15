package org.uiowa.cs2820.engine;

public class LinearFileDatabase implements Database {
	private static String fileName = "keyvalue.txt";
	protected KeyStorage keyStore = new KeyStorage(this,fileName);
	protected ValueStorage valStore = new ValueStorage(this,fileName);
	
	@Override
	public Node fetch(byte[] key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(byte[] key, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(byte[] key, String id) {
		// TODO Auto-generated method stub
		
	}

}
