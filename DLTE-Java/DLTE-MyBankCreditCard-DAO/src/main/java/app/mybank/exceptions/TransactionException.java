package app.mybank.exceptions;

import java.util.ResourceBundle;

public class TransactionException extends RuntimeException{
    public TransactionException(){
        super(ResourceBundle.getBundle("transaction").getString("transaction.exception"));
    }
    public TransactionException(String information){
        super(ResourceBundle.getBundle("transaction").getString("transaction.exception")+" "+information);
    }
}
