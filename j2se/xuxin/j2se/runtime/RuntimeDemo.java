package xuxin.j2se.runtime;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * 学习 Runtime 操作系统命令
 * @version 1.0
 * @author xuxin 
 * @data 2013-3-7
 */
public class RuntimeDemo {

    public static Log logger = LogFactory.getLog(RuntimeDemo.class);
    
    @Test
    public void testA() {
        // getRuntime()获取当前运行时应用程序的Runtime实例
        Runtime rt = Runtime.getRuntime();
        try {
            // exec()执行系统 cmd 命令并返回 process进程对象，用于管理进程
            // Process pro = rt.exec("cmd /c dir f:\\oracle");
            Process pro = rt.exec("cmd /c ipconfig /all");
            // Process pro = rt.exec("taskmgr");
            // Process pro = rt.exec(new String[] {"cmd.exe","/c","dir f:\\oracle","dir e:\\333"});
            
            // 进程输入流,中文的话需要指定“GBK”  <获取系统命令输出的信息>
            BufferedInputStream in = new BufferedInputStream(pro.getInputStream());
            BufferedReader bf = new BufferedReader(new InputStreamReader(in,"GBK"));
            String result = null;
            
            while ((result = bf.readLine()) != null) {
                System.out.println(result);
            }
            
            // 检查命令是否执行失败
            // pro.waitFor()        0 表示进程正常终止
            if (pro.waitFor() != 0) {
                // pro.exitValue() == 0 表示命令正常结束，1表示命令非正常结束
                if (pro.exitValue() == 1) {
                    System.out.println("【错误】 命令执行失败..");
                }
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 测试从控制台输入命令并执行
     * 【注】未成功！  好像无法继续向系统命令传入参数了！
     */
    @Test
    public void testC() {
        try {
            Process pro = Runtime.getRuntime().exec("cmd /c dir f:\\oracle");
            
            // 进程输出流   <往系统命令输入信息>
            BufferedWriter out = null;
            
            // 进程输入流  <获取系统命令的输出信息>
            BufferedReader in = null;
            
            // 系统命令输出信息
            String result = null;
            
            // 获取输入流
            in = new BufferedReader(new InputStreamReader(new BufferedInputStream(pro.getInputStream()),"GBK"));
            while ((result = in.readLine()) != null) {
                System.out.println(result);
            }
            System.out.println("输入流0：" + in);
            /*boolean b = true;
            String s = null;
            while (b) {
                s = in.readLine();
                if (s != null) {
                    System.out.println(s);
                } else {
                    in.close();
                }
            }*/
            
            System.out.println("请输入cmd命令：");
            
            // 控制台监听操作命令
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            String command = null;
            
            while (flag) {
                if ((command = sc.nextLine()) != null) {
                    if ("end".equalsIgnoreCase(command)) {
                        flag = false;
                    } else {
                        System.out.println("[cmd：] " + command);
                        
                        // 获取输出流
                        out = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(pro.getOutputStream())));
                        out.write(command);
                        System.out.println("输出流：" + out);
                        out.close();
                        
                        // 获取输入流
                        in = new BufferedReader(new InputStreamReader(new BufferedInputStream(pro.getInputStream()),"GBK"));
                        while ((result = in.readLine()) != null) {
                            System.out.println(result);
                        }
                        System.out.println("输入流：" + in);
                    }
                }
                
                
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
