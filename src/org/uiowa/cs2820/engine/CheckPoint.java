package org.uiowa.cs2820.engine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class CheckPoint {

	private String fileName;

	// constructor of checkpoint
	public CheckPoint(String fileName) {
		this.fileName = fileName;
	}

	// check the file existence
	public boolean isExists() {

		File file = new File(fileName);
		if (file.exists()) {
			return true;
		} else
			return false;
	}

	// can take a big Java Object convert to byte array and write into files
	public void save(Object obj) {
		try {
			ByteArrayOutputStream byteout = new ByteArrayOutputStream();
			ObjectOutput objout = new ObjectOutputStream(byteout);
			objout.writeObject(obj);

			File file = new File(fileName);
			FileOutputStream outfile = new FileOutputStream(file);
			outfile.write(byteout.toByteArray());
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while writing file " + ioe);
		}
	}

	// read file, convert bytes back into original object
	public Object restore() {
		Object obj = null;
		try {
			File file = new File(fileName);
			FileInputStream infile = new FileInputStream(file);

			byte fileContent[] = new byte[(int) file.length()];
			ObjectInput objout = new ObjectInputStream(infile);

			objout.read(fileContent);
			obj = objout.readObject();

		} catch (IOException ioe) {
			System.out.println("Exception while writing file " + ioe);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
