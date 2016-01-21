/**
 * 
 */
package xuxin.org.dom4j;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 用于创建、删除、复制文件的类
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-7
 */
public class FileTool {

    /**
     * 在指定目录下创建指定名称的目录文件
     * @param fileName 目录/文件名
     * @throws IOException 
     */
    public static File createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (file.isDirectory()) {               //创建目录
                file.mkdirs();
            }else {
                File dir = file.getParentFile();    //获取目录
                if (dir != null) {
                    if (!dir.exists()) {
                        dir.mkdirs();               //创建级联目录
                    }
                }
                file.createNewFile();               //创建文件
            }
        }
        return file;
    }
    
    /**
     * 删除指定位置的目录/文件
     * @param fileName 目录/文件名
     */
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file != null) {
            file.delete();
        }
    }
    
    /**
     * 复制指定的文件或文件夹到指定的位置
     * @param file 原文件
     * @param copyFile 复制的后的文件
     */
    public static void copyDir(File file,File copyFile) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();   //获取该目录下所有的file
            for (File f:files) {
                copyDir(f,copyFile);            //递归
            }
        }else {
            copyFile(file,copyFile);            //拷贝文件
        }
    }

    /**
     * 拷贝文件
     * @param file
     * @param copyFile
     */
    private static void copyFile(File file, File copyFile) {
        BufferedReader in = null;
        PrintStream out = null;
        
        //需要先创建目录再创建文件，否则最后的文件会生成文件夹
        if (!copyFile.exists()) {
            File dir = copyFile.getParentFile();     //获取该文件所在的文件夹
            if (dir != null) {
                if (!dir.exists()) {
                    dir.mkdirs();       //级联创建文件夹目录
                }
            }
            try {
                copyFile.createNewFile();    //创建文件
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            in = new BufferedReader(new FileReader(file));
            //参数true表示追加
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(copyFile,true)));
            boolean flag = true;
            
            while (flag) {
                String str = in.readLine();
                if (str != null) {
                    out.println(str);
                }else {
                    flag = false;
                }
            }
            
            in.close();
            out.flush();     //这里好像必须flush,不然文件里没有内容
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
