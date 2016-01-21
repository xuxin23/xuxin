package xuxin.j2se.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {
	
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		File file = new File("D:/temp/Dogs.txt");
		
		try {
			out = new ObjectOutputStream
			(new FileOutputStream(file, true));
			Dog d1 = new Dog("旺财",2);
			Dog d2 = new Dog("黑子",4);
			Dog d3 = new Dog("花花",6);
			out.writeObject(d1);
			out.writeObject(d2);
			out.writeObject(d3);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
