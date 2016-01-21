package xuxin.j2se.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectReader {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		File file = new File("D:/temp/Dogs.txt");
		
			try {
				in = new ObjectInputStream
				(new FileInputStream(file));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ArrayList<Dog> list = new ArrayList<Dog>();
			
			/*
			 * 如何检查边界，如果用if (in.readObject = null)判断的
			 * 话，是会 抛出异常的，和其他的边界检查不一样。
			 * ObjectOutputStream的边界检查就是异常的抛出，抛出IO
			 * 异常就说明到达边界了。这时需要在catch语句中处理异常
			 * 就是处理到达边界后的 情况，应该关闭流和跳出while循环
			 * 让程序继续下去。 思想：以前一直以为异常的抛出只是找错
			 * 用的，其实在 catch语句中可 以用异常作为边界或其它条件
			 * 判断的！！
			 * */
			boolean flag = true;
			while (flag) {
				try {
					list.add((Dog)in.readObject());
				} catch (IOException e1) {	//抛出异常，说明到达边界
					try {
						in.close();			//关闭流
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					flag = false;			//跳出while循环
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			for (Dog e:list) {
				System.out.println("编号：" + e.getNum() + "\t昵称：" + 
						e.getName() + "\t年龄：" + e.getAge());
			}
	}
}
