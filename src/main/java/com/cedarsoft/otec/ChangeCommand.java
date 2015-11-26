package main.java.com.cedarsoft.otec;

public class ChangeCommand implements Command {
	  private final Receiver receiver;
	  private final int id;

	  private final AddressBook addressBook;
	  private Receiver old;
	  
	  public ChangeCommand(int id,Receiver receiver, AddressBook addressbook ){
			this.addressBook=addressbook;
			this.receiver=receiver;
			this.id=id;
		}
	  
	@Override
	public void execute() {
		old = addressBook.delete(id);
		addressBook.store(id, receiver);

	}

	@Override
	public void undo() {
		addressBook.delete(id);
		addressBook.store(id, old);

	}

}
