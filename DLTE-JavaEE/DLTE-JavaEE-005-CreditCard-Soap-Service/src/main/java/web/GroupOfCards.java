package web;

import app.mybank.entity.CreditCard;

import java.util.List;

public class GroupOfCards {
    private List<CreditCard> creditCards;

    @Override
    public String toString() {
        return "GroupOfCards{" +
                "creditCards=" + creditCards +
                '}';
    }

    public GroupOfCards() {
    }

    public GroupOfCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
