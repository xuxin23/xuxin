package xuxin.j2se.io;

import java.io.File;
/**
 * 获取文件目录
 * 和拷贝文件夹类型，递归处理
 * @author xuxin
 */
public class Tree {
	private static int count = 0;
	
	public static void main(String[] args) {
		File file = new File("E:\\SoftWare");
		Tree.getTree(file);
	}
	
	public static void getTree(File file) {
		count++;
		int num = count;
		String str = Tree.getString(num);
		File[] files = file.listFiles();
		for (File f:files) {
			System.out.print(str);
			if (f.isDirectory()) {
				System.out.println("+" + f.getName());
				Tree.getTree(f);
			}else {
				System.out.println(f.getName());
			}
		}
		count--;
	}
	
	public static String getString(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<num; i++) {
			sb = sb.append("  ");
		}
		return sb.toString();
	}
}
