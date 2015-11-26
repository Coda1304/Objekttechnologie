package main.java.com.cedarsoft.otec;

public class RemoveCommand implements Command {
	 
	private Receiver deleted;
	private final int id;

	private final AddressBook addressBook;
	
	public RemoveCommand(  int id, AddressBook addressbook ){
		this.addressBook=addressbook;
		this.id=id;
	}
	
	@Override
	public void execute() {
		deleted = addressBook.delete(id);

	}

	@Override
	public void undo() {
		addressBook.store(id , deleted);

	}

}
