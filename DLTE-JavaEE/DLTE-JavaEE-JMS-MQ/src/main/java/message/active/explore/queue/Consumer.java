package message.active.explore.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection= factory.createConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createQueue("ethnic");
        MessageConsumer consumer=session.createConsumer(destination);

        TextMessage message=null;String msg="";
        do{
            System.out.println("Received the information/message ");
            message= (TextMessage) consumer.receive();
            msg=message.getText();
            System.out.println(msg);
        }while(!msg.equalsIgnoreCase("lets wind up"));

        session.close();
        connection.close();
    }
}
