package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyStorageTest {

	static String fileName = "keyStorageTest.txt";
	@Test
	public void InitializationTest() {
		LinearFileDatabase db = new LinearFileDatabase(fileName);
		assertEquals(db.keyStore.fileName,fileName);
		assertEquals(db.keyStore.db,db);
	}

}
