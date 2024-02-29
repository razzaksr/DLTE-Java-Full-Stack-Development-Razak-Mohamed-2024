package app.mybank;

import app.mybank.entity.CreditCard;
import app.mybank.entity.Transaction;
import app.mybank.exceptions.CreditCardException;
import app.mybank.middleware.FileStorageTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;
import app.mybank.services.TransactionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);
//        String bank1="ICICI";String bank2="icici";
//        System.out.println(bank1.compareTo(bank2));
        // database/ file system
//        StorageTarget storageTarget=new FileStorageTarget();
//
//        CreditCardServices services=new CreditCardServices(storageTarget);
        CreditCardServices services=new CreditCardServices();
        //services.callSave(new CreditCard(7656787656L,874,new Date("1/31/2035"),100000,80000,20000,1111,true,"Razak Mohamed S"));
//        CreditCard creditCard=new CreditCard(7656787656L,122,new Date("5/30/2032"),50000,40000,10000,1234,true,"Razak Mohamed S");
//        try{
//            services.callSave(creditCard);
//        }
//        catch (CreditCardException creditCardException){
//            System.out.println("Enter the card number");
//            creditCard.setCardNumber(scanner.nextLong());
//            services.callSave(creditCard);
//        }
//        System.out.println(services.callFindAll());
//        try{
//            System.out.println(services.callFindById(111111111L));
//        }
//        catch (CreditCardException creditCardException){
//            System.out.println(creditCardException);
//            System.out.println("Enter the card number");
//            System.out.println(services.callFindById(scanner.nextLong()));
//        }

//        try{
//            System.out.println(services.callFindAllByLimit(200000));;
//        }
//        catch (CreditCardException creditCardException){
//            System.out.println(creditCardException);
//            System.out.println("Enter the another limit to filter");
//            System.out.println(services.callFindAllByLimit(scanner.nextInt()));
//        }
//        CreditCard myCreditCard=new CreditCard(7654676766L,123,new Date("1/31/2032"),50000,40000,10000,3333,true,"Razak Mohamed S");
//        try{
//            services.callUpdate(myCreditCard);
//            System.out.println(services.callFindAll());
//        }
//        catch (CreditCardException creditCardException){
//            System.out.println(creditCardException);
//            System.out.println("Enter the existing credit card number");
//            myCreditCard=new CreditCard(scanner.nextLong(), 123,new Date("1/31/2032"),50000,30000,20000,3333,false,"Elroy");
//            services.callUpdate(myCreditCard);
//            System.out.println(services.callFindAll());
//        }
//        CreditCard myCreditCard=new CreditCard(765787656L,123,new Date("1/31/2032"),50000,30000,20000,3333,true,"Elroy");
//        try{
//            services.callDelete(myCreditCard);
//            System.out.println(services.callFindAll());
//        }
//        catch (CreditCardException creditCardException){
//            System.out.println(creditCardException);
//            System.out.println("Enter the existing credit card number");
//            myCreditCard=new CreditCard(scanner.nextLong(), 123,new Date("1/31/2032"),50000,30000,20000,3333,false,"Elroy");
//            services.callDelete(myCreditCard);
//            System.out.println(services.callFindAll());
//        }
        TransactionService transactionService=new TransactionService();

//        Transaction transaction=new Transaction();
//        transaction.setMerchant(11223344);
//        transaction.setTransactionAmount(15000.0);
//        transaction.setTransactionDate(new Date("2/11/2024"));
//        transaction.setTransactionDoneBy(7654676766L);
//
//        transactionService.callSave(transaction,"Saravana bhavan");

        System.out.println(transactionService.callFindAll());
    }
}
