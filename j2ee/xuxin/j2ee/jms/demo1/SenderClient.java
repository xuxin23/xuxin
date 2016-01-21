package xuxin.j2ee.jms.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQQueueConnectionFactory;

/**
 * 往队列QUEUE_TEST放消息
 * @author xuxin
 *
 */
public class SenderClient {

	public static void main(String[] args) throws JMSException {
		String qmgrName = "QM_TEST";
		String localQueueName = "QUEUE_TEST";
		
		MQQueueConnectionFactory queueConnectionFactory = new MQQueueConnectionFactory();
		queueConnectionFactory.setQueueManager(qmgrName);
		QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
		queueConnection.start();
		// ture表示使用事务,相应模式选择0; 那么必须session.commit才能最终发送消息
		// false表示不使用事务,相应模式选择1; 那么不用commit
		QueueSession queueSession = queueConnection.createQueueSession(false, 1);
		Queue queue = queueSession.createQueue(localQueueName);
		QueueSender queueSender = queueSession.createSender(queue);
		
		String[] textArr = {"中国加油！","IBM WebSphere MQ","精通JavaScript面向对象","魔都上海","文都桐城","自信、坚强、乐观、有梦想！"};
		while (true) {
			int i = (int) (Math.random() * textArr.length);
			String text = textArr[i] + " - " + new SimpleDateFormat("HH:mm:ss").format(new Date());
			TextMessage message = queueSession.createTextMessage();
			message.setText(text);
			queueSender.send(message);
			
			try {
				Thread.sleep(2000 + (long)Math.random() * 5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
