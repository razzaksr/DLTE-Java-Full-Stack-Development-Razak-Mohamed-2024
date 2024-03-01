package app.mybank;

import app.mybank.entity.CreditCard;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StorageTarget storageTarget=new DatabaseTarget();

        CreditCardServices creditCardServices=new CreditCardServices(storageTarget);

////        CreditCard creditCard=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,20000,71000,4844,true,"Annapoorna Pai");
//        creditCardServices.callSave(creditCard);
//        System.out.println(creditCardServices.callFindAll());
//        System.out.println(creditCardServices.callFindById(111122343L));
//        System.out.println(creditCardServices.callFindAllByLimit(101000));;
//        CreditCard creditCard=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,true,"Annapoorna Pai");
////        creditCardServices.callUpdate(creditCard);
//        creditCardServices.callDelete(creditCard);
    }
}
