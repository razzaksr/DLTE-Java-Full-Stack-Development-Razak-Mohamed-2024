package app.mybank.entity;

import java.io.Serializable;
import java.util.Date;

public class CreditCard implements Serializable {
    private Long cardNumber;
    private Integer cardCvv;
    private Date cardExpiry;
    private Integer cardLimit;
    private Integer cardAvailable;
    private Integer cardUsage;
    private Integer cardPin;
    private boolean cardStatus;
    private String cardHolder;

    public CreditCard() {
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", cardCvv=" + cardCvv +
                ", cardExpiry=" + cardExpiry +
                ", cardLimit=" + cardLimit +
                ", cardAvailable=" + cardAvailable +
                ", cardUsage=" + cardUsage +
                ", cardPin=" + cardPin +
                ", cardStatus=" + cardStatus +
                ", cardHolder='" + cardHolder + '\'' +
                '}';
    }

    public CreditCard(Long cardNumber, Integer cardCvv, Date cardExpiry, Integer cardLimit, Integer cardAvailable, Integer cardUsage, Integer cardPin, boolean cardStatus, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardCvv = cardCvv;
        this.cardExpiry = cardExpiry;
        this.cardLimit = cardLimit;
        this.cardAvailable = cardAvailable;
        this.cardUsage = cardUsage;
        this.cardPin = cardPin;
        this.cardStatus = cardStatus;
        this.cardHolder = cardHolder;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(Integer cardCvv) {
        this.cardCvv = cardCvv;
    }

    public Date getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(Date cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Integer cardLimit) {
        this.cardLimit = cardLimit;
    }

    public Integer getCardAvailable() {
        return cardAvailable;
    }

    public void setCardAvailable(Integer cardAvailable) {
        this.cardAvailable = cardAvailable;
    }

    public Integer getCardUsage() {
        return cardUsage;
    }

    public void setCardUsage(Integer cardUsage) {
        this.cardUsage = cardUsage;
    }

    public Integer getCardPin() {
        return cardPin;
    }

    public void setCardPin(Integer cardPin) {
        this.cardPin = cardPin;
    }

    public boolean isCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(boolean cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}
