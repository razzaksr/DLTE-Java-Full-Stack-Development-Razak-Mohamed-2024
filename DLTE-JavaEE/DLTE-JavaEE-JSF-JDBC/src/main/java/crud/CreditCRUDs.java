package crud;

import app.mybank.entity.CreditCard;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.CreditCardRepository;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;

@ManagedBean
@SessionScoped
public class CreditCRUDs {
    private Collection<CreditCard> creditCards;
    private StorageTarget storageTarget;
    private CreditCardServices services;
    private CreditCard currentCard=new CreditCard();

    public CreditCard getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(CreditCard currentCard) {
        this.currentCard = currentCard;
    }

    public CreditCRUDs() {
        storageTarget=new DatabaseTarget();
        services=new CreditCardServices(storageTarget);
        implementFetchAll();
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    // CRUD operations

    public void implementFetchAll(){
        creditCards=services.callFindAll();
    }

    public void addCard(){
        services.callSave(currentCard);
        currentCard=new CreditCard();
    }
}
