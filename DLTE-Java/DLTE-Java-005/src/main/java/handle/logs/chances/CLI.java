package handle.logs.chances;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLI {
    public static void main(String[] args){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        MyAccount myAccount=new MyAccount();
        myAccount.accountNumner=8765456785678L;myAccount.accountBalance=90003.45;
        int toBeDebited=0;
        try{
            toBeDebited=Integer.parseInt(args[0]);
            if(myAccount.accountBalance>=toBeDebited){
                myAccount.accountBalance-=toBeDebited;
                System.out.println(toBeDebited+" has debited successfully");
            }
            else{
                System.out.println("Insufficient fund in account");
            }
        }
        catch (NumberFormatException exception){
            System.out.println(exception);
//            System.out.println(resourceBundle.getString("format.number"));
            logger.log(Level.INFO,resourceBundle.getString("format.number"));
//            main(new String[]{"2500"});
            args[0]="2500";
            toBeDebited=Integer.parseInt(args[0]);
            if(myAccount.accountBalance>=toBeDebited){
                myAccount.accountBalance-=toBeDebited;
                System.out.println(toBeDebited+" has debited successfully");
            }
            else{
                System.out.println("Insufficient fund in account");
            }
        }
        finally {
            System.out.println("Thanks for visiting MyBank ATM");
        }
    }
}

class MyAccount{
    long accountNumner;
    double accountBalance;
}