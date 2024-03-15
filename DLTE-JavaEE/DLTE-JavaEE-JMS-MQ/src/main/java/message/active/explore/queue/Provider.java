package message.active.explore.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class Provider {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=activeMQConnectionFactory.createConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createQueue("ethnic");
        MessageProducer producer=session.createProducer(destination);

        Scanner scanner=new Scanner(System.in);
        String info="";

        do{
            System.out.println("Send the information/message ");
            info=scanner.nextLine();
            TextMessage message=session.createTextMessage(info);
            producer.send(message);
        }while(!info.equalsIgnoreCase("lets wind up"));


        scanner.close();
        session.close();
        connection.close();
    }
}
