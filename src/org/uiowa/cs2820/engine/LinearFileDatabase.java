package org.uiowa.cs2820.engine;

public class LinearFileDatabase implements Database {
	
	protected KeyStorage keyStore = new KeyStorage(this);
	protected ValueStorage valStore = new ValueStorage(this);
	
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
