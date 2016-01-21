package xuxin.j2se.thread.demo5ArrayBlockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * 单线程处理文本搜索任务
 * 【用来与多线程处理的时间作对比】
 * @author xuxin
 * @date 2013-7-8
 */
public class Client0 {

	public static void main(String[] args) {
		System.out.println("单线程任务..");
		Scanner in = new Scanner(System.in);
		System.out.println("请输入搜索的文件夹:");
		String dir = in.nextLine();
		System.out.println("请输入搜索的文本:");
		String keyword = in.nextLine();
		
		// 程序开始时间
		long startTime = new Date().getTime();
		// 程序结束时间
		long endTime;
		
		enumerateAndSearch(new File(dir), keyword);
		endTime = new Date().getTime();
		System.out.println("搜索结束，共用时间 " + new Date(endTime - startTime).getSeconds() + " 秒.");
	}
	
	private static void enumerateAndSearch(File dir, String keyword) {
		File[] files = dir.listFiles();
		for (File file:files) {
			if (file.isDirectory()) {
				enumerateAndSearch(file, keyword);
			} else {
				Scanner in;
				try {
					in = new Scanner(file);
					int lineNumber = 0;
					
					boolean printFlag = false;
					while (in.hasNextLine()) {
						lineNumber++;
						String line = in.nextLine();
						if (line.contains(keyword)) {
							if (!printFlag) {
								System.out.println();
								System.out.println(file.getPath() + "\t[" + Thread.currentThread().getName() + "]");
								printFlag = true;
							}
							System.out.println("\t" + lineNumber + "行\t" + line);
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
