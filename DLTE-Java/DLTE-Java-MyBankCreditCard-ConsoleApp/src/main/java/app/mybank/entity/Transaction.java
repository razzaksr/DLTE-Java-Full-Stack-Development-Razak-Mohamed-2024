package app.mybank.entity;

import java.io.Serializable;
import java.util.Date;
// transaction model/entity/business model
public class Transaction implements Serializable {
    private Integer transactionId;
    private Date transactionDate;
    private Long transactionDoneBy;
    private Double transactionAmount;
    private String transactionReceiver;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionDate=" + transactionDate +
                ", transactionDoneBy=" + transactionDoneBy +
                ", transactionAmount=" + transactionAmount +
                ", transactionReceiver='" + transactionReceiver + '\'' +
                '}';
    }

    public Transaction(Date transactionDate, Long transactionDoneBy, Double transactionAmount, String transactionReceiver) {
        this.transactionDate = transactionDate;
        this.transactionDoneBy = transactionDoneBy;
        this.transactionAmount = transactionAmount;
        this.transactionReceiver = transactionReceiver;
    }

    public Transaction() {
    }

    public Transaction(Integer transactionId, Date transactionDate, Long transactionDoneBy, Double transactionAmount, String transactionReceiver) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionDoneBy = transactionDoneBy;
        this.transactionAmount = transactionAmount;
        this.transactionReceiver = transactionReceiver;
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

    public String getTransactionReceiver() {
        return transactionReceiver;
    }

    public void setTransactionReceiver(String transactionReceiver) {
        this.transactionReceiver = transactionReceiver;
    }
}
