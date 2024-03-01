package app.mybank.remotes;

// by service

public interface StorageTarget {
    CreditCardRepository getCreditCardRepository();
    TransactionRepository getTransactionRepository();
}
