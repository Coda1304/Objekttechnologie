package main.java.com.cedarsoft.otec;

import java.util.*;

public class AddressBook {
	private final Map<Integer, Receiver> receivers = new HashMap<Integer, Receiver>();
	
	public void store(int id, Receiver receiver){
		receivers.put(id, receiver);
	}
	
	public Receiver delete(int id){
		return receivers.remove(id);
	}
	
	public int getSize(){
		return receivers.size();
	}
	
	public Receiver getEntry(int id){
		Receiver found = receivers.get(id);
		if(found == null){
			throw new IllegalArgumentException( "No entry found for id <" + id + ">" );
		}
		return found;
	}
}
