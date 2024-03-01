package app.mybank;

import app.mybank.entity.CreditCard;
import app.mybank.entity.Transaction;
import app.mybank.exceptions.CreditCardException;
import app.mybank.exceptions.MyBankJarvisException;
import app.mybank.exceptions.TransactionException;
import app.mybank.middleware.CreditCardDatabaseRepository;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.middleware.FileStorageTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;
import app.mybank.services.TransactionService;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static StorageTarget storageTarget;
    private static CreditCardServices services;
    private static TransactionService transactionService=new TransactionService();
    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    private static Scanner scanner=new Scanner(System.in);
    private static CreditCard creditCard;
    public static void main( String[] args )
    {
//        storageTarget=new FileStorageTarget();
        storageTarget=new DatabaseTarget();
        services=new CreditCardServices(storageTarget);
        System.out.println(resourceBundle.getString("app.greet"));
        loggingIn();
        if(creditCard==null) {
            return;
        }
        else{
            int option=0;
            do{
                System.out.println(resourceBundle.getString("app.menu"));
                option= scanner.nextInt();
                switch (option){
                    case 1:
                        System.out.println("Enter the details you wish update among (limit,usage,available,pin)");
                        String userInput= scanner.next();// available,pin
                        String[] properties=userInput.split(",");
                        int size= properties.length;
                        for(int index=0;index<size;index++){
                            if(properties[index].equalsIgnoreCase("limit")){
                                System.out.println("Enter the new limit ");
                                creditCard.setCardLimit(scanner.nextInt());
                            }
                            if(properties[index].equalsIgnoreCase("usage")){
                                System.out.println("enter the current usage");
                                creditCard.setCardUsage(scanner.nextInt());
                            }
                            if(properties[index].equalsIgnoreCase("available")){
                                System.out.println("enter the available limit ");
                                creditCard.setCardAvailable(scanner.nextInt());
                            }
                            if(properties[index].equalsIgnoreCase("pin")){
                                System.out.println("Enter the old pin");
                                if(creditCard.getCardPin().equals(scanner.nextInt())){
                                    System.out.println("Set new pin");
                                    creditCard.setCardPin(scanner.nextInt());
                                }
                                else{
                                    System.out.println("PIN can't set");
                                }
                            }
                        }
                        services.callUpdate(creditCard);
                        break;
                    case 2:
                        System.out.println("Enter the Transaction details such as merchant name,id,amount");
                        Transaction transaction=new Transaction();
                        transaction.setTransactionDoneBy(creditCard.getCardNumber());
                        transaction.setTransactionDate(new Date());
                        String nameOfTheMerchant= scanner.next();
                        transaction.setMerchant(scanner.nextInt());
                        transaction.setTransactionAmount(scanner.nextDouble());
                        try{
                            transactionService.callSave(transaction,nameOfTheMerchant);
                        }
                        catch (TransactionException transactionException){
                            System.out.println(transactionException);
                        }
                        break;
                    case 3:
                        System.out.println("View transaction");
                        System.out.println(transactionService.callFindAllByCreditCard(creditCard.getCardNumber()));
                        break;
                    case 4:
                        System.out.println("View card");
                        try{
                            System.out.println(services.callFindById(creditCard.getCardNumber()));
                        }
                        catch (CreditCardException creditCardException){
                            System.out.println(creditCardException);
                        }
                        break;
                    case 5:
                        System.out.println("Handover the card");
                        creditCard.setCardStatus(false);
                        try{
                            services.callUpdate(creditCard);
                        }
                        catch (CreditCardException creditCardException){
                            System.out.println(creditCardException);
                        }
                        break;
                    default:return;
                }
            }while (true);
        }
    }
    public static void loggingIn(){
        CreditCard current=null;
        try{
            System.out.println(resourceBundle.getString("app.log.number"));
            current = services.callFindById(scanner.nextLong());
            if(current.isCardStatus()){
                System.out.println(resourceBundle.getString("app.log.pin"));
                Integer pin= scanner.nextInt();
                if(current.getCardPin().equals(pin)){
                    App.creditCard=current;
                    System.out.println(resourceBundle.getString("app.log.ok"));
                }
                else{
                    throw new MyBankJarvisException();
                }
            }
            else{
                System.out.println(resourceBundle.getString("app.log.lock"));
            }
        }
        catch (CreditCardException creditCardException){
            System.out.println(creditCardException);
            App.loggingIn();
        }
        catch(MyBankJarvisException jarvisException){
            for(int attempt=2;attempt<=3;){
                System.out.println(jarvisException);
                Integer pin= scanner.nextInt();
                if(current.getCardPin().equals(pin)){
                    App.creditCard=current;
                    System.out.println(resourceBundle.getString("app.log.ok"));
                    return;
                }
                else{
                    System.out.println(resourceBundle.getString("app.log.fail")+" attempted "+attempt);
                    attempt++;
                }
            }
            System.out.println(resourceBundle.getString("app.log.lock"));
            current.setCardStatus(false);
            services.callUpdate(current);
        }
    }
}
////        String bank1="ICICI";String bank2="icici";
////        System.out.println(bank1.compareTo(bank2));
//        // database/ file system
////        StorageTarget storageTarget=new FileStorageTarget();
////
////        CreditCardServices services=new CreditCardServices(storageTarget);
//        CreditCardServices services=new CreditCardServices();
//        //services.callSave(new CreditCard(7656787656L,874,new Date("1/31/2035"),100000,80000,20000,1111,true,"Razak Mohamed S"));
////        CreditCard creditCard=new CreditCard(13727363L,192,new Date("10/28/2035"),100000,60000,40000,9999,true,"Sanath");
////        try{
////            services.callSave(creditCard);
////        }
////        catch (CreditCardException creditCardException){
////            System.out.println("Enter the card number");
////            creditCard.setCardNumber(scanner.nextLong());
////            services.callSave(creditCard);
////        }
////        System.out.println(services.callFindAll());
////        try{
////            System.out.println(services.callFindById(111111111L));
////        }
////        catch (CreditCardException creditCardException){
////            System.out.println(creditCardException);
////            System.out.println("Enter the card number");
////            System.out.println(services.callFindById(scanner.nextLong()));
////        }
//
////        try{
////            System.out.println(services.callFindAllByLimit(200000));;
////        }
////        catch (CreditCardException creditCardException){
////            System.out.println(creditCardException);
////            System.out.println("Enter the another limit to filter");
////            System.out.println(services.callFindAllByLimit(scanner.nextInt()));
////        }
////        CreditCard myCreditCard=new CreditCard(7654676766L,123,new Date("1/31/2032"),50000,40000,10000,3333,true,"Razak Mohamed S");
////        try{
////            services.callUpdate(myCreditCard);
////            System.out.println(services.callFindAll());
////        }
////        catch (CreditCardException creditCardException){
////            System.out.println(creditCardException);
////            System.out.println("Enter the existing credit card number");
////            myCreditCard=new CreditCard(scanner.nextLong(), 123,new Date("1/31/2032"),50000,30000,20000,3333,false,"Elroy");
////            services.callUpdate(myCreditCard);
////            System.out.println(services.callFindAll());
////        }
////        CreditCard myCreditCard=new CreditCard(765787656L,123,new Date("1/31/2032"),50000,30000,20000,3333,true,"Elroy");
////        try{
////            services.callDelete(myCreditCard);
////            System.out.println(services.callFindAll());
////        }
////        catch (CreditCardException creditCardException){
////            System.out.println(creditCardException);
////            System.out.println("Enter the existing credit card number");
////            myCreditCard=new CreditCard(scanner.nextLong(), 123,new Date("1/31/2032"),50000,30000,20000,3333,false,"Elroy");
////            services.callDelete(myCreditCard);
////            System.out.println(services.callFindAll());
////        }
//        TransactionService transactionService=new TransactionService();
//
////        Transaction transaction=new Transaction();
////        transaction.setMerchant(11223355);
////        transaction.setTransactionAmount(12000.0);
////        transaction.setTransactionDate(new Date("2/3/2024"));
////        transaction.setTransactionDoneBy(13727363L);
////
////        transactionService.callSave(transaction,"De Sofas");
////
////        System.out.println(transactionService.callFindAll());
////        System.out.println(transactionService.callFindAllByCreditCard(7654676766L));
////        System.out.println(transactionService.callFindAllByCreditCard(765467676L));