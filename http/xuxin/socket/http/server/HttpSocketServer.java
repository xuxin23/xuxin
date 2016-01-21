package xuxin.socket.http.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Http服务器端模拟
 * @author xuxin
 */
public class HttpSocketServer {

	public static Log logger = LogFactory.getLog(HttpSocketServer.class);
	
	public static void main(String[] args) {
		logger.info("HttpSocketServer is starting ..");
		
		// 启动服务
		ServerSocket serverSocket = null;
		boolean shutdown = false;
		try {
			serverSocket = new ServerSocket(8080,1,InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 线程池
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		// 监听请求
		while (!shutdown) {
			Socket socket = null;
			logger.info("wait ..");
			
			try {
				socket = serverSocket.accept();
				pool.submit(new RequestHandler(socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
