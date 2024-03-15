package message.active.explore.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class Publisher {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=activeMQConnectionFactory.createConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createTopic("mybank");
        MessageProducer publisher=session.createProducer(destination);

        Scanner scanner=new Scanner(System.in);
        String info="";

        do{
            System.out.println("Send the information/message ");
            info=scanner.nextLine();
            TextMessage message=session.createTextMessage(info);
            publisher.send(message);
        }while(!info.equalsIgnoreCase("lets wind up"));


        session.close();
        scanner.close();
        connection.close();
    }
}
