package xuxin.j2ee.mail;

/**
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class Mail {

    //收件人邮箱
    private String to;
    
    //邮件主题
    private String subject;
    
    //邮件内容
    private String content;

    public Mail() {
        
    }
    
    public Mail(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
