package app.mybank.exceptions;

import java.util.ResourceBundle;

public class CreditCardException extends RuntimeException{
    public CreditCardException(){
        super(ResourceBundle.getBundle("credtcard").getString("card.exception"));
    }
}
