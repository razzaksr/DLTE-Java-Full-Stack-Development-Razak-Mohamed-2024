package app.mybank.exceptions;

import java.util.ResourceBundle;

public class MyBankJarvisException extends RuntimeException{
    public MyBankJarvisException(){
        super(ResourceBundle.getBundle("application").getString("app.log.fail"));
    }
}
