
package xuxin.j2ee.mail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * 邮件发送测试环境
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class Client {

    private static Log logger = LogFactory.getLog(Client.class);
    
    @Test
    public void testSendMail() {
        
        List<Mail> mails = new ArrayList<Mail>();
        String[] mailServers = {"@qq.com", "@126.com", "@163.com"};
//        String[] mailServers = {"@qq.com"};
        
        //散布垃圾邮件
        for (int i = 0; i < 10; i++) {
            String random = String.valueOf(new Double((100000 + Math.random() * 1000000000)).intValue());
            for (String mailServer:mailServers) {
                String toAddress = random + mailServer;
                logger.info("自动生成的邮件地址: " + toAddress);
                
                Mail mail = new Mail();
                mail.setTo(toAddress);
                mail.setSubject("中奖通知" + toAddress);
                mail.setContent("^_^恭喜您中得5元，请先汇200元手续费到xxx.." + toAddress);
                
                mails.add(mail);
            }
        }
        mails.add(new Mail("954076071@qq.com","邮件系统测试","恭喜测试成功！"));
        
        //获取邮件系统类
        MailSystem mailSystem = MailSystem.getInstance();
        //设置处理的线程个数
        mailSystem.setThreadCount(3);
        //发送邮件
        mailSystem.send(mails);
        
        while (true) {
            // 无限延长主线程生命周期
        }
    }
}
