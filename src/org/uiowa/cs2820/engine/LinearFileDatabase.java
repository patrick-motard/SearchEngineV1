package org.uiowa.cs2820.engine;

public class LinearFileDatabase implements Database {
	protected String fileName;
	protected KeyStorage keyStore;
	protected ValueStorage valStore;
	LinearFileDatabase(String fileName) {
		this.fileName = "keyvalue.txt";
		this.keyStore = new KeyStorage(this,fileName);
		this.valStore = new ValueStorage(this,fileName);
	}
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
