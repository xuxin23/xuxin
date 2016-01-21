/**
 * 
 */
package xuxin.j2ee.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class MailSender implements Cloneable{

    //系统邮箱服务器
    String host = "smtp.126.com";
    
    //系统邮箱
    String from = "ibatis1989@126.com";
    
    //系统邮箱密码
    String psw = "abcde12345";
    
    //邮件信息(收件人、主题、内容)
    Mail mail;
    
    /**
     * 发送邮件
     */
    public void send() throws AddressException, MessagingException {
        //初始化邮件发送的设置
        MimeMessage message = initMessage();
        
        //发送邮件
        Transport.send(message);
    }

    /**
     * 初始化
     * @throws MessagingException 
     * @throws AddressException 
     */
    private MimeMessage initMessage() throws AddressException, MessagingException {
        Properties props = System.getProperties();
        //Setup mail server
        props.put("mail.smtp.host", host);
        //这样才能通过验证
        props.put("mail.smtp.auth", "true");
        
        //利用Authenticator通过用户名和密码访问受保护的资源,即邮件服务器
        //校验发件人权限
        MyAuthenticator myauth = new MyAuthenticator(from, psw);
        
        //获取基本邮件会话，其他所有JavaMail API都是经由这个Session才得以生效
        Session session = Session.getDefaultInstance(props, myauth);
        session.setDebug(false);
        
        //创建要发送的消息
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.saveChanges();
        
        return message;
    }
    
    //重写clone方法
    public MailSender clone() {
        MailSender mailSender = null;
        try {
            mailSender = (MailSender) super.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mailSender;
    }
    
    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

}
