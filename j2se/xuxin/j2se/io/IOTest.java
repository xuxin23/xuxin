package xuxin.j2se.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * 测试一些IO流的知识
 * @version 1.0
 * @author xuxin 
 * @data 2013-2-21
 */
public class IOTest {

    /**
     * 测试 OutputStream
     * write(int i):        写入 unicode 编码 - 会转化为对应的 unicode 字符
     * write(byte[] b)      写入 字节数组
     * 【总结】 OutputStream 就是以 unicode 编码形式写入 字节的，write(int i)是单个写入字节，
     * 而 write(byte[] b) 是一次写入多个字节，其中byte[] 中的每个字节 都可以转化成 unicode 对应
     * 的字符
     */
    @Test
    public void testOutputSteam() {
    	File file = new File("D:/1.txt");
    	if (!file.exists()) {
    		try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	OutputStream out = null;
        try {
            out = new FileOutputStream(file, true);
            
            // 读入字节数组
            byte[] b = new String("Hello, HuaTeng!").getBytes();
            for (byte e:b) {
                System.out.println(e);
            }
            out.write(b);
            // 读入int [注]这里的int 并不是具体的数字，而是 unicode 编码！！ 如这里的 68 对应
            out.write(68);
            
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 测试 InputStream
     * read():          读取下一个字节，返回的是 该字符的 unicode码，-1表示读取到末尾
     *                  转化成 char,转化成char[],转化成String
     * read(byte[] b)   读取一定数量的字节，并存放在字节数组 b 中，返回的是读取的字节个数
     * 【总结】能说什么，感觉理解透彻了！
     */
    @Test
    public void testInputStream() {
    	File file = new File("D:\\1.txt");
    	if(!file.exists()) {
    		try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            String str = "";
            
            // 读取单个字节
            int a;
            if ((a = in.read()) > 0) {
            	str += new String(new char[] {(char)a});
            }
            System.out.println("----------" + str);
            
            // 读取字节数组
            byte[] b = new byte[1024];
            int n;
            while ((n = in.read(b)) > 0) {
                str += new String(b, 0, n);
            }
            in.close();
            System.out.println(str);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 测试 Writer
     * write(String str):       直接写入字符串，很方便
     * 其他的方法不方便..
     */
    @Test
    public void testWriter() {
        Writer out = null;
        try {
            out = new FileWriter("D:/2.txt");
            String str = "测试字符流 Writer";
            // 字符流就是为了方便使用的，直接写入 字符串就可以了
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 测试 Reader
     * read():              读取单个字符，返回unicode整数字符(0-65535),到达末尾返回-1
     * read(char[] c):      读取多个字符，并保存在字符数组 c 中，到达末尾返回-1
     * 【总结】和 InputStream 类似
     */
    @Test
    public void testReader() {
    	File file = new File("D:\\2.txt");
    	if  (!file.exists()) {
    		try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
        Reader in = null;
        try {
            in = new FileReader(file);
            char[] c = new char[1024];
            int n;
            String str = "";
            while ((n = in.read(c)) > 0) {
                str += new String(c, 0, n);
            }
            System.out.println(str);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 测试 ByteArrayInputStream 和 ByteArrayOutputStream
     */
    @Test
    public void testByteArray() {
        String str = "hello ByteArray..";
        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;
        
        in = new ByteArrayInputStream(str.getBytes());
        out = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = in.read()) != -1) {
            char c = (char)temp;
            out.write(Character.toUpperCase(c));
        }
        
        System.out.println(out.toString());
    }
	
    /**
     * 字符流复制文件
     * 【注】只能读取文本文件TXT
     */
    @Test
    public void testBaseIO() {
        BufferedReader in = null;
        PrintStream out = null;
        File file = new File("E:/11.docx");
        
        try {
            in = new BufferedReader(new FileReader(file));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream("E:/22.docx")));
            
            boolean flag = true;
            while (flag) {
                String str = in.readLine();
                if (str != null) {
                    out.println(str);
                } else {
                    flag = false;
                }
            }
            
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 字节流复制文件
     * 【注】可复制任何格式的文件
     */
    @Test
    public void testCommonIo() {
        FileInputStream in = null;
        FileOutputStream out = null;
        File file = new File("E:/11.jpg");
        
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream("E:/22.jpg");
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
