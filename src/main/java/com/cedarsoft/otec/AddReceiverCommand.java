package main.java.com.cedarsoft.otec;

public class AddReceiverCommand implements Command{
	  private final Receiver receiver;
	  private final int id;

	  private final AddressBook addressBook;
	 
	public AddReceiverCommand( int id, Receiver receiver, AddressBook addressbook ){
		this.addressBook=addressbook;
		this.receiver=receiver;
		this.id=id;
	}
	
	@Override
	public void execute() {
		addressBook.store(id, receiver);
		
	}

	@Override
	public void undo() {
		addressBook.delete(id);
	}

	

}
