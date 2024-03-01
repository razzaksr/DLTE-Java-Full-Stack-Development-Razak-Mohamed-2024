package app.mybank.services;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.middleware.CreditCardDatabaseRepository;
import app.mybank.remotes.CreditCardRepository;
import app.mybank.remotes.StorageTarget;
import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

// api call to the repository implementation

public class CreditCardServices {
    CreditCardRepository creditCardRepository;
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("database");

//    public CreditCardServices(StorageTarget storageTarget){
//        creditCardRepository=storageTarget.getCreditCardRepository();
//    }
    public CreditCardServices(StorageTarget storageTarget){
//        creditCardRepository=new CreditCardFileRepository("mybank-creditcard.doc");
        creditCardRepository= storageTarget.getCreditCardRepository();
    }

    public void callSave(CreditCard creditCard){
        try{
            creditCardRepository.save(creditCard);
        }
        catch(CreditCardException creditCardException){
            throw creditCardException;
        }
    }

    public List<CreditCard> callFindAll(){
        return creditCardRepository.findAll();
    }

    public CreditCard callFindById(Long cardNumber){
        try{
            return creditCardRepository.findById(cardNumber);
        }
        catch (CreditCardException creditCardException){
            throw creditCardException;
        }
    }

    public List<CreditCard> callFindAllByLimit(Integer limit){
        try {
            return creditCardRepository.findAllByLimit(limit);
        }
        catch (CreditCardException creditCardException){
            throw creditCardException;
        }
    }

    public void callUpdate(CreditCard creditCard){
        try{
            creditCardRepository.update(creditCard);
        }
        catch(CreditCardException creditCardException){
            throw creditCardException;
        }
    }

    public void callDelete(CreditCard creditCard){
        try{
            creditCardRepository.delete(creditCard);
        }
        catch (CreditCardException creditCardException){
            throw creditCardException;
        }
    }
}
