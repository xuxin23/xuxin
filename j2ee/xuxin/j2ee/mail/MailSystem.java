/**
 * 
 */
package xuxin.j2ee.mail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 邮件系统
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class MailSystem {

    private static Log logger = LogFactory.getLog(MailSystem.class);
    
    //单例
    private static MailSystem mailSystem;
    
    //线程个数
    private int threadCount = 2;
    
    private MailSystem() {
        
    }
    
    /**
     * 获取MailSystem单例
     */
    public static MailSystem getInstance() {
        if (mailSystem == null) {
            synchronized(MailSystem.class) {
                mailSystem = new MailSystem();
                logger.debug("singleton-mailSystem is created..");
            }
        }
        return mailSystem;
    }
    
    /**
     * 将邮件分配给多个线程并行处理
     */
    public void send(List<Mail> mails) {
        
        //每个线程负责的邮件个数
        int avgMails = mails.size() / threadCount;
        //多余的邮件
        int yu = mails.size() % threadCount;
        
        //生成线程
        for (int i = 0; i < threadCount; i++) {
            //每个线程负责的邮件集合
            List<Mail> list = new ArrayList<Mail>();
            int count;
            if (i == 0) {
                count = avgMails + yu;
            } else {
                count = avgMails;
            }
            
            //从总的邮件集合移除邮件到线程的邮件集合
            for (int j = 0; j < count; j++) {
                list.add(mails.remove(0));
            }
            
            //新建线程处理
            Thread thread = new Thread(new MailThread(list));
            thread.start();
        }
    }

    /**
     * 获取邮件的处理线程个数
     */
    public int getThreadCount() {
        return threadCount;
    }

    /**
     * 设置邮件的处理线程个数
     */
    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }
    
    
}
