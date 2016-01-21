package xuxin.j2se.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 将指定的目录完全拷贝到D:/temp下
 * @version 1.2 20121130
 * @author xuxin
 *
 */
public class CopyFile {
    
    /*
     * 递归函数获取所有的文件
     */
    public static void copyDir(File inDir) {
        
        if (inDir.isDirectory()) {
            File[] files = inDir.listFiles();   //获取该目录下所有的file
            for (File file:files) {
                copyDir(file);  //递归
            }
        }else {
            copyFlie(inDir);    //拷贝文件
        }
    }
    
    /*
     * 拷贝文件
     */
    private static void copyFlie(File inFile) {
        BufferedReader in = null;
        PrintStream out = null;
        
        File outFile = new File("D:/temp/" + inFile.getPath().replace("\\", "/"));  //文件拷贝的位置
        //需要先创建目录再创建文件，否则最后的文件会生成文件夹
        if (!outFile.exists()) {
            File dir = outFile.getParentFile();     //获取该文件所在的文件夹
            if (dir != null) {
                if (!dir.exists()) {
                    dir.mkdirs();       //级联创建文件夹目录
                }
            }
            try {
                outFile.createNewFile();    //创建文件
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            in = new BufferedReader(new FileReader(inFile));
            //参数true表示追加
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile,true)));
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

    public static void main(String[] args) {
        //将当前包拷贝到D:/temp下
        copyDir(new File("src"));
    }
}
