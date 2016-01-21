package xuxin.j2ee.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ProductImpl extends UnicastRemoteObject implements IProduct{

	private static final long serialVersionUID = 1L;
	private String desc;
	private NiceBook book;
	
	protected ProductImpl(String desc) throws RemoteException {
		this.desc = desc;
	}

	public String getDescription() throws RemoteException {
		return "I am a [ " + desc + " ], it is RMI test..";
	}

	public NiceBook getBook() throws RemoteException {
		return (book == null) ? new NiceBook() : this.book;
	}
	
	public void setBook(NiceBook book) {
		this.book = book;
	}

}
