package app.mybank.remotes;

import app.mybank.entity.Merchant;
import app.mybank.entity.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction, String merchantName);
    List<Transaction> findAll();
    List<Transaction> findAllByCreditCard(Long cardNumber);
    List<Transaction> findAllByDate(Date date);
    List<Transaction> findAllByMerchant(Integer merchantId);
    void saveMerchant(Merchant merchant);
}
