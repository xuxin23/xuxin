/**
 * 
 */
package xuxin.j2ee.mail;

/**
 * 邮件计数器
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class Counter {

    /**
     * 发送成功的邮件个数
     */
    private static int success = 0;
    
    /**
     * 发送失败的邮件个数
     */
    private static int failed = 0;
    
    /**
     * 发送邮件总个数
     */
    private static int sum = 0;
    
    /**
     * 计数
     */
    public synchronized static void count(boolean bool) {
        sum++;
        if (bool == true) {
            success++;
        } else {
            failed++;
        }
    }
    
    /**
     * 显示Counter信息
     */
    public static String show() {
        return "发送邮件总个数：" + getSum() + ", 其中成功个数为：" + 
                getSuccess() + ", 失败个数为：" + getFailed();
    }
    
    /**
     * 得到发送成功的邮件个数
     */
    public static int getSuccess() {
        return success;
    }
    
    /**
     * 得到发送失败的邮件个数
     */
    public static int getFailed() {
        return failed;
    }
    
    /**
     * 得到发送邮件的总数
     */
    public static int getSum() {
        return sum;
    }
    
    
}
