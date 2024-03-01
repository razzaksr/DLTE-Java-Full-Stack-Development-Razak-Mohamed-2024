package app.mybank.entity;

import java.io.Serializable;
import java.util.Date;
// transaction model/entity/business model
public class Transaction implements Serializable {
    private Integer transactionId;
    private Date transactionDate;
    private Long transactionDoneBy;
    private Double transactionAmount;

    private Integer merchant;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionDate=" + transactionDate +
                ", transactionDoneBy=" + transactionDoneBy +
                ", transactionAmount=" + transactionAmount +
                ", merchant=" + merchant +
                '}'+"\n";
    }

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public Transaction() {
    }

    public Transaction(Integer transactionId, Date transactionDate, Long transactionDoneBy, Double transactionAmount, Integer merchant) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionDoneBy = transactionDoneBy;
        this.transactionAmount = transactionAmount;
        this.merchant = merchant;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getTransactionDoneBy() {
        return transactionDoneBy;
    }

    public void setTransactionDoneBy(Long transactionDoneBy) {
        this.transactionDoneBy = transactionDoneBy;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

}
