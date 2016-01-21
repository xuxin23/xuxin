package xuxin.socket.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 发送HTTP请求
 * @author xuxin
 *
 */
public class HttpSocketClient {

	public static Log logger = LogFactory.getLog(HttpSocketClient.class);
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8080);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 向服务端发送HTTP请求
			out.println("POST /index.jsp?a=1&b=2 HTTP/1.1");
			out.println("Host: localhost:8080");
			out.println("Connection: Close");
			out.println("");	// HTTP协议是以空行作为报头和报体的分隔标识(仅模拟HTTP而已)
			out.println("username=kobe&password=123456");
			out.flush();
			
			// 接收服务端返回的HTTP应答
			boolean loop = true;
			boolean isStarted = false;//是否开始接收标志
			StringBuffer responseData = new StringBuffer("");
			while (loop) {
				Thread.sleep(10);
				if (in.ready()) {
					isStarted = true;
					responseData.append(in.readLine() + "\r\n");
				} else {
					// 如果相隔一段时间且已开始接收，而 缓冲区的可读数据没有变化，则认为已经接收完成，跳出循环
					loop = isStarted == true?false:true;
				}
			}
			logger.info("--> requestData:\r\n" + responseData);
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
