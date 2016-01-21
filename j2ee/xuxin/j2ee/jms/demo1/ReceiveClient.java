package xuxin.j2ee.jms.demo1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQQueueConnectionFactory;

/**
 * 监听队列QUEUE_TEST,当有消息到达时取出消息
 * @author xuxin
 *
 */
public class ReceiveClient {
	private static String qmgrName = "QM_TEST";
	private static String localQueueName = "QUEUE_TEST";
	
	public static void main(String[] args) throws JMSException {
		MQQueueConnectionFactory queueConnectionFacotry = new MQQueueConnectionFactory();
		queueConnectionFacotry.setQueueManager(qmgrName);
		QueueConnection queueConnection = queueConnectionFacotry.createQueueConnection();
		queueConnection.start();
		QueueSession queueSession = queueConnection.createQueueSession(false, 1);
		Queue queue = queueSession.createQueue(localQueueName);
		QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		
		queueReceiver.setMessageListener(new MessageListener() {
			public void onMessage(Message msg) {
				if (msg instanceof TextMessage) {
					try {
						System.out.println(((TextMessage) msg).getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		while (true) {
			// 主线程持续存活
		}
	}
}
