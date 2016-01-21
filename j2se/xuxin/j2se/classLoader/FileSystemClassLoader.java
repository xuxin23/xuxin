package xuxin.j2se.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器，加载指定路径下的class文件
 * 涉及的知识点：
 * 1.ClassLoader的加载体系及具体实现
 *      |-双亲委派模式，优先交由父类加载，父类再交由它的父类加载；父类加载不了，抛出异常，子类
 *        捕获异常，在异常处理中调用自己的findClass()加载，加载不了的话继续抛出异常，子类的子类
 *        捕获异常，在异常处理中调用自己的findClass()加载...
 * 2.ByteArrayOutputStream流
 *      |-此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。
 *        可使用 toByteArray()和 toString()获取数据。 
 *
 * @author xuxin
 *
 */
public class FileSystemClassLoader extends ClassLoader{
	private String rootDir;
	
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	/*
	 * LoadClass()方法继承自ClassLoader,在子类中一般不重写，因为要在loadClass中
	 * 实现代理模式(先将加载任务交由父类加载器加载，父类加载不了才由子类加载器加载)
	 * 子类重写findClass()方法，以在父类加载器加载不了的时候，自己加载
	 * 
	 * */
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		//加载class字节码
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		}else {
			//调用defineClass()将class字节码转换成class并返回
			return defineClass(name,classData,0,classData.length);
		}
	}
	
	//加载指定目录下的文件并转换成字节码数组
	private byte[] getClassData(String className) {
		String path = classNameToPath(className);
			InputStream ins;
			try {
				ins = new FileInputStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int bufferSize = 4096;
				byte[] buffer  = new byte[bufferSize];
				int bytesNumRead = 0;
				//ins.read(buffer)返回每次读取的字节码数量
				while ((bytesNumRead = ins.read(buffer)) != -1) {
					baos.write(buffer,0,bytesNumRead);
				}
				//调用toByteArray()将ByteArrayOutputStream读取的字节码数据转换成
				//字节码数组
				return baos.toByteArray();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	//将类路径转换成文件路径
	private String classNameToPath(String className) {
		return rootDir + File.separatorChar + className.replace('.', File.separatorChar)+".class";
	}
}
