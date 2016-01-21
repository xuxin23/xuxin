/**
 * 
 */
package xuxin.j2ee.mail;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 发送邮件的线程
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class MailThread implements Runnable{

    private static Log logger = LogFactory.getLog(MailThread.class);
    
    private List<Mail> mails;
    
    //MailSender模板
    private MailSender mailSenderTemplate = new MailSender();
    
    public MailThread() {
        
    }
    
    public MailThread(List<Mail> mails) {
        this.mails = mails;
    }
    
    public void run() {
        for (Mail mail:this.getMails()) {
            //clone模板得到新的MailSender
            MailSender mailSender = mailSenderTemplate.clone();
            mailSender.setMail(mail);
            try {
                logger.info("[准备] 主题为 '" + mail.getSubject() + 
                        "' 的邮件准备发送...[" + mail.getTo() + "]");
                mailSender.send();
                //计数器
                Counter.count(true);
                logger.info("[成功] 主题为" + mail.getSubject() +
                        "的邮件发送成功..[" + mail.getTo() + "]");
            }
            catch (AddressException e) {
                //计数器
                Counter.count(false);
                logger.error("[异常] 主题为 '" + mail.getSubject() + 
                        "' 的邮件发送失败..[" + mail.getTo() + "]");
            }
            catch (MessagingException e) {
                //计数器
                Counter.count(false);
                logger.error("[异常] 主题为 '" + mail.getSubject() + 
                        "' 的邮件发送失败..[" + mail.getTo() + "]");
            }
            finally {
                try {
                    Thread.sleep((long) (1000 + Math.random() * 5000));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        logger.info("当前线程结束，计数器结果为：" + Counter.show());
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }

    
}
