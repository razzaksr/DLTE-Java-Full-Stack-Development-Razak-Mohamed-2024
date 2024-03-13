package web;

import javax.xml.ws.Endpoint;

public class SoapEndpoints {
    private static String url="http://localhost:1234/ankitha";
    public static void main(String[] args) {
        CreditCardSoap creditCardSoap=new CreditCardSoap();
        System.out.println("Webservice hosted @ "+url);
        Endpoint.publish(url,creditCardSoap);
    }
}
