package xuxin.j2se.messageDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class messageDigestDemo {

	@Test
	public void testMD5() {
		try {
			String message = "This is a demo of message digest.";
			
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] msg = digest.digest(message.getBytes());
			
			String str = "MD5:\t";
			// 以16进制显示
			for (byte b:msg) {
				int v = b & 0xFF;
				if (v < 16) str += "0";
				str += Integer.toHexString(v).toUpperCase() + " ";
			}
			System.out.println(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSHA_1() {
		try {
			String message = "This is a demo of message digest.";
			
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte[] arr = digest.digest(message.getBytes());
			
			String str = "SHA-1:\t";
			for (byte b:arr) {
				int v = b & 0xff;
				if (v < 16) str += "0";
				str += Integer.toHexString(v).toUpperCase() + " ";
			}
			System.out.println(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
