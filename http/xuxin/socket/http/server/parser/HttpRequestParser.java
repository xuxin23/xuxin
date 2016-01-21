package xuxin.socket.http.server.parser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import xuxin.socket.http.server.domain.HttpRequest;

/**
 * 将HTTP请求数据解析到HttpRequest
 * @author xuxin
 *
 */
public class HttpRequestParser {

	public static HttpRequest parseRequest(String requestData) throws IOException {
		HttpRequest request = new HttpRequest();
		BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(requestData.getBytes())));
		String line = null;
		while ((line = in.readLine()) != null) {
			if (line.contains("POST")) {
				String[] elements = line.split(" ");
				String[] parts = elements[1].split("\\?");
				if (parts.length == 2) {
					String[] parameters = parts[1].split("\\&");
					for (int i=0; i<parameters.length; i++) {
						String[] arr = parameters[i].split("=");
						request.setParameter(arr[0], arr[1]);
					}
				}
			}
			if (line.contains("Connection")) {
				
			}
		}
		in.close();
		return request;
	}
}
