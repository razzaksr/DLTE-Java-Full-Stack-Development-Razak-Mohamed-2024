package app.mybank.middleware;

import app.mybank.remotes.CreditCardRepository;
import app.mybank.remotes.StorageTarget;
import app.mybank.remotes.TransactionRepository;

public class FileStorageTarget implements StorageTarget {
    @Override
    public CreditCardRepository getCreditCardRepository() {
        return new CreditCardFileRepository("mybank-creditcard.doc");
    }

    @Override
    public TransactionRepository getTransactionRepository() {
        return null;
    }
}
