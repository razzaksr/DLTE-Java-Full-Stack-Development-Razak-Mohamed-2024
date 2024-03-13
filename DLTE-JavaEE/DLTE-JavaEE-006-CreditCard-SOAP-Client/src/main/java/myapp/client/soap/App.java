package myapp.client.soap;

import web.CreditCard;
import web.CreditCardSoap;
import web.CreditCardSoapService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CreditCardSoapService creditCardSoapService=new CreditCardSoapService();
        CreditCardSoap soap= creditCardSoapService.getCreditCardSoapPort();
//        List<CreditCard> cards = soap.readAll().getCreditCards();//.forEach(System.out::println);
//        for(CreditCard each:cards){
//            System.out.println(each.getCardHolder()+" "+each.getCardNumber());
//        }

        CreditCard creditCard = soap.readOne(11111122343L);
        System.out.println(creditCard.getCardHolder()+" "+creditCard.getCardAvailable()+" "+creditCard.getCardUsage());

    }
}
