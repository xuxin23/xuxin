package xuxin.j2ee.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 客户端、服务器端同时存在的接口
 * @author xuxin
 * @date 2013-7-29
 */
public interface IProduct extends Remote{

	String getDescription() throws RemoteException;
	NiceBook getBook() throws RemoteException;
}
