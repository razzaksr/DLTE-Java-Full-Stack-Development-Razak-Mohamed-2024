package app.mybank.services;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.middleware.CreditCardFileRepository;
import app.mybank.remotes.CreditCardRepository;
import app.mybank.remotes.StorageTarget;

import java.util.List;

// api call to the repository implementation

public class CreditCardServices {
    CreditCardRepository creditCardRepository;

//    public CreditCardServices(StorageTarget storageTarget){
//        creditCardRepository=storageTarget.getCreditCardRepository();
//    }
    public CreditCardServices(){
        creditCardRepository=new CreditCardFileRepository("mybank-creditcard.doc");
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
