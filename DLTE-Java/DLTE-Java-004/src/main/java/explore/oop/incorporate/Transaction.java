package explore.oop.incorporate;

public class Transaction {
    private Customer sender;
    private Integer amount;
    private Customer Receiver;
    private String typeOfTransaction;

    @Override
    public String toString() {
        return "Transaction{" +
                "sender=" + sender +
                ", amount=" + amount +
                ", Receiver=" + Receiver +
                ", typeOfTransaction='" + typeOfTransaction + '\'' +
                '}';
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Customer getReceiver() {
        return Receiver;
    }

    public void setReceiver(Customer receiver) {
        Receiver = receiver;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public Transaction() {
    }

    public Transaction(Customer sender, Integer amount, Customer receiver, String typeOfTransaction) {
        this.sender = sender;
        this.amount = amount;
        Receiver = receiver;
        this.typeOfTransaction = typeOfTransaction;
    }
}
