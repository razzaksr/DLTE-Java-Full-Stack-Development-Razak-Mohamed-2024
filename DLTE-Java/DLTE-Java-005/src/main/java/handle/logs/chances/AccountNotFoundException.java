package handle.logs.chances;

import java.util.ResourceBundle;

public class AccountNotFoundException extends RuntimeException{
//    private static String message;
//    static {
//        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
//        message=resourceBundle.getString("exception.account");
//    }
    public AccountNotFoundException(){
//        super(message);
        super(ResourceBundle.getBundle("application").getString("exception.account"));
    }
}
