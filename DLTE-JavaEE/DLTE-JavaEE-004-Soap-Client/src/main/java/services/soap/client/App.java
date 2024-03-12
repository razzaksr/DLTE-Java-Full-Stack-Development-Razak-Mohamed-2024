package services.soap.client;

import initial.MySource;
import initial.MySourceService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MySourceService service=new MySourceService();
        MySource source=service.getMySourcePort();
        String acknowledge = source.addDeafulter("Sinchana");
        System.out.println(acknowledge);
    }
}
