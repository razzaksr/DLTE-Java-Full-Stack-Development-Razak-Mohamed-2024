package message.active.explore.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class SubscriberTransaction {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=activeMQConnectionFactory.createConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createTopic("mybank");
        MessageConsumer subscriber=session.createConsumer(destination);

        Scanner scanner=new Scanner(System.in);
        String info="";

        TextMessage message=null;String msg="";
        do{
            System.out.println("Received the information/message ");
            message= (TextMessage) subscriber.receive();
            msg=message.getText();
            System.out.println(msg);
        }while(!msg.equalsIgnoreCase("lets wind up"));


        session.close();
        scanner.close();
        connection.close();
    }
}
