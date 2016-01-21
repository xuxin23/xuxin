/**
 * 
 */
package xuxin.j2se.base;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

/**
 * 字符集和字符编码测试
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-19
 */
public class CharsetTest {

    /**
     * 打印部分unicode码表
     */
    @Test
    public void PrintUnicode() {
        for (int i=0;i<25000;i++) {
            System.out.print((char)i);
        }
        System.out.println();
    }
    
    /**
     * 打印字符串的字节数组
     */
    @Test
    public void PrintByteArr() {
        // java内存中默认unicode编码
        String str = "中文";
        
        // 打印unicode字节数组
        byte[] unicodeArr = str.getBytes();
        System.out.println(Arrays.toString(unicodeArr));
        
        // 打印iso8859-1字节数组
        try {
            byte[] isoArr = str.getBytes("iso8859-1");
            System.out.println(Arrays.toString(isoArr));
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        // 打印gbk字节数组
        try {
            byte[] gbkArr = str.getBytes("gbk");
            System.out.println(Arrays.toString(gbkArr));
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        // 打印utf-8字节数组
        try {
            byte[] utfArr = str.getBytes("utf-8");
            System.out.println(Arrays.toString(utfArr));
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 打印不同编码相互转换的情况
     */
    @Test
    public void PrintCharset() {
        /**
                                 【测试A】，“中文”以iso8859-1编码，再以其他编码识别为字符
                                 分析：“中文”在iso8859-1字符集不存在，所以会返回2个其码表中‘？’对应的的字节；
                                  若以iso8859-1编码识别该字节数组时，当然会显示“？？”；
                                  若以gbk编码识别该字节数组时，寻找这两个字节对应其字符集的字符，会和iso8859-1一样显示“？？”，因为gbk是兼容iso8859-1的；
                                  若以utf-8编码识别该字节数组时，和gbk一样
           */
        String str = "中文";
        try {
            System.out.println("-----------------【测试A】，“中文”以iso8859-1编码，再以其他编码识别为字符----------------------");
            byte[] isoArr = str.getBytes("iso8859-1");
            printC(isoArr);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        /**
                             【测试B】,“中文”以gbk编码，再以其他编码识别为字符
                              分析：“中文”在gbk字符集存在，所以会返回4个其码表中“中文”对应的字节；
                              若以iso8859-1编码识别该字节数组时，以"单字节方式"寻找这4个字节对应其码表的字符，显示4个单字节奇怪字符；
                              若以gbk编码识别该字节数组时，以"双字节方式"寻找这4个字节对应其码表的字符，显示2个双字节的字节“中文”；
                              若以utf-8编码识别该字节数组时，以"三字节方式"寻找这4个字节对应其码表的字符，显示乱码；
         */
        String str2 = "中文";
        try {
            System.out.println("--------------------【测试B】,“中文”以gbk编码，再以其他编码识别为字符-------------------------");
            byte[] gbkArr = str2.getBytes("gbk");
            printC(gbkArr);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        /**
                             【测试C】,“中文”以utf8编码，再以其他编码识别为字符
                             分析同上
         */
        String str3 = "中文";
        System.out.println("-----------------------【测试C】,“中文”以utf8编码，再以其他编码识别为字符-----------------------");
        try {
            byte[] utfArr = str.getBytes("utf-8");
            printC(utfArr);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    // 打印指定字节数组合成的不同编码字符
    private void printC(byte[] byteArr) throws UnsupportedEncodingException{
        System.out.println(new String(byteArr, "iso8859-1"));
        System.out.println(new String(byteArr, "gbk"));
        System.out.println(new String(byteArr, "utf-8"));
    }
}
