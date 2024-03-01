package app.mybank.exceptions;

import java.util.ResourceBundle;

public class CreditCardException extends RuntimeException{
    public CreditCardException(){
        super(ResourceBundle.getBundle("creditcard").getString("card.exception"));
    }
    public CreditCardException(String additionalInfo){
        super(ResourceBundle.getBundle("creditcard").getString("card.exception")+" "+additionalInfo);
    }
}
