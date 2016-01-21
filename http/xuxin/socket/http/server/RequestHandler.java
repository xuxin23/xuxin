package xuxin.socket.http.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xuxin.socket.http.server.domain.HttpRequest;
import xuxin.socket.http.server.parser.HttpRequestParser;

/**
 * 处理socket的线程
 * @author xuxin
 *
 */
public class RequestHandler implements Runnable{

	private static Log logger = LogFactory.getLog(RequestHandler.class);
	private Socket socket;
	
	public RequestHandler() {}
	
	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 处理每个socket连接请求
	 */
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		// 设置连接超时时间
		try {
			socket.setSoTimeout(60000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			// 接收客户端的HTTP请求
			boolean loop = true;
			boolean isStarted = false;//是否开始接收标志
			StringBuffer requestData = new StringBuffer("");
			while (loop) {
				Thread.sleep(10);
				if (in.ready()) {
					isStarted = true;
					requestData.append(in.readLine() + "\r\n");
				} else {
					// 如果相隔一段时间且已开始接收，而 缓冲区的可读数据没有变化，则认为已经接收完成，跳出循环
					loop = isStarted == true?false:true;
				}
			}
			logger.info("--> requestData:\r\n" + requestData);
			
			HttpRequest request = HttpRequestParser.parseRequest(requestData.toString());
			System.out.println("[TEST] " + request.getParameter("a"));
			
			// 向服务器端发送HTTP应答
			out.println("HTTP/1.1 200 OK");
			out.println("ContentType: text/html");
			out.println("Connection: Close");
			out.println();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Welcome to come to xuxin's world!</h1>");
			out.println("</body>");
			out.println("</html>");
			out.flush();
			
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
