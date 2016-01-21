package xuxin.net.sf.json;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import xuxin.j2se.domain.User;

/**使用json.jar来将Bean转换为JSON或者将JSON转换为Bean
 * [注] json.jar主要用于ajax,在服务器端将Bean对象以JSON字符串的形式返回
 * 给客户端。    如果使用struts2的话，也可以使用struts2内置的json插件。
 * @version 1.0
 * @author xuxin 
 * @data 2013-2-18
 */
public class JSONDemo {

    private static Log logger = LogFactory.getLog(JSONDemo.class);
    
    /**
     * 测试Bean转换为JSON
     */
    @Test
    public void testBean2JSON() {
        // bean
        User user = new User();
        user.setName("kobe");
        user.setPassword("123456");
        
        // json
        JSONObject json = new JSONObject();
        json.accumulate("success", true);
        json.accumulate("user", user);
        
        // 输出JSON字符串
        logger.info(">> 转换后的JSON字符串：" + json.toString());
    }
    
    /**
     * 测试JSON转换为Bean
     */
    @Test
    public void testJSON2Bean() {
        // bean
        User user = new User();
        user.setName("kobe");
        user.setPassword("123456");
        
        // json
        JSONObject json = new JSONObject();
        json.accumulate("success", true);
        json.accumulate("user", user);
        
        // json2Bean
        User user2 = (User) JSONObject.toBean((JSONObject)json.get("user"), User.class);
        
        // 输出转换后的Bean的属性
        logger.info(">> 转换后的Bean的属性：" + user2.getName() + " - " + user2.getPassword());
    }
}
