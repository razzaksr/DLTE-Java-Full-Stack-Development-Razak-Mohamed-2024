package web;

import app.mybank.entity.CreditCard;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CreditCardSoap {
    public CreditCardServices services;
    public CreditCardSoap(){
        StorageTarget storageTarget=new DatabaseTarget();
        services=new CreditCardServices(storageTarget);
    }

    @WebMethod
    public void blockCard(@WebParam(name = "CreditCard") CreditCard creditCard){
        services.callDelete(creditCard);
    }

    @WebMethod
    public void createCard(@WebParam(name="CreditCard") CreditCard creditCard){
        services.callSave(creditCard);
    }

    @WebMethod
    @WebResult(name="GroupOfCards")
    public GroupOfCards readAllByLimit(@WebParam(name="Integer") Integer limit){
        GroupOfCards groupOfCards=new GroupOfCards();
        List<CreditCard> myList = services.callFindAllByLimit(limit);
        groupOfCards.setCreditCards(myList);
        return groupOfCards;
    }

    @WebMethod
    @WebResult(name="CreditCard")
    public CreditCard readOne(@WebParam(name="Long") Long cardNumber){
        return services.callFindById(cardNumber);
    }

    @WebMethod
    @WebResult(name="GroupOfCards")
    public GroupOfCards readAll(){
        GroupOfCards constructList=new GroupOfCards();
        List<CreditCard> myCards = services.callFindAll();
        constructList.setCreditCards(myCards);
        return constructList;
    }
}
