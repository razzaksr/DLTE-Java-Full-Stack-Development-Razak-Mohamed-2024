package app.mybank.middleware;

import app.mybank.entity.Transaction;
import app.mybank.remotes.TransactionRepository;

import java.util.Date;
import java.util.List;

public class TransactionFileRepository implements TransactionRepository {

    @Override
    public void save(Transaction transaction) {

    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public List<Transaction> findAllByCreditCard(Long cardNumber) {
        return null;
    }

    @Override
    public List<Transaction> findAllByDate(Date date) {
        return null;
    }
}
