package org.uiowa.cs2820.engine;
import java.io.*;

@SuppressWarnings("serial")
public class LinkedListObject implements Serializable {
	private Object obj;
	private int next;
	private int areaNum;
	

	LinkedListObject (Object obj, int next, int areaNum) {
		this.obj = obj;
		this.next = next;
		this.areaNum = areaNum;
	}
	Object getObject() {
		return this.obj;
	}
	
	int getNext() {
		return this.next;
	}
	int getSelf() {
		return this.areaNum;
	}
	void setNext(int areaNum) {
		this.next = areaNum;
	}
	void setSelf(int areaNum) {
		this.areaNum = areaNum;
	}

}
