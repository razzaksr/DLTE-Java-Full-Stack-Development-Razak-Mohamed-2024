package myapp.client.soap;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import web.CreditCard;
import web.CreditCardSoap;
import web.CreditCardSoapService;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

//        CreditCard creditCard = soap.readOne(11111122343L);
//        System.out.println(creditCard.getCardHolder()+" "+creditCard.getCardAvailable()+" "+creditCard.getCardUsage());

//        List<CreditCard> cards = soap.readAllByLimit(60000).getCreditCards();
//
//        for(CreditCard creditCard:cards){
//            System.out.println(creditCard.getCardHolder()+" "+creditCard.getCardExpiry());
//        }
//        CreditCard creditCard=new CreditCard();
//        creditCard.setCardPin(1111);
//        creditCard.setCardStatus(true);
//        creditCard.setCardHolder("Akshira");
//        creditCard.setCardNumber(342893489342L);
//        creditCard.setCardAvailable(20000);
//        creditCard.setCardUsage(480000);
//        creditCard.setCardCvv(111);
//        creditCard.setCardLimit(9500000);
//        creditCard.setCardExpiry(new Date("12/10/2030"));
//        soap.createCard(creditCard);

//        CreditCard creditCard=new CreditCard();
//        creditCard.setCardNumber(11111122343L);
//        soap.blockCard(creditCard);
    }
}
