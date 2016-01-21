/**
 * 
 */
package xuxin.j2ee.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 校验发信人权限
 * @version 1.0
 * @author xuxin 
 * @data 2013-1-16
 */
public class MyAuthenticator extends Authenticator{

    private String id;
    private String password;
    
    public MyAuthenticator(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(id, password);
    }
}
