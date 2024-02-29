package app.mybank.services;

import app.mybank.entity.Transaction;
import app.mybank.exceptions.TransactionException;
import app.mybank.middleware.TransactionFileRepository;
import app.mybank.remotes.TransactionRepository;

import java.util.List;

public class TransactionService {
    TransactionRepository transactionRepository;
    public TransactionService(){
        transactionRepository=new TransactionFileRepository("transaction.doc","merchants.doc");
    }

    public void callSave(Transaction transaction,String merchantName){
        try{
            transactionRepository.save(transaction,merchantName);
        }
        catch (TransactionException transactionException){
            System.out.println(transactionException);
        }
    }

    public List<Transaction> callFindAll(){
        return transactionRepository.findAll();
    }

    public List<Transaction> callFindAllByCreditCard(Long cardNumber){
        return transactionRepository.findAllByCreditCard(cardNumber);
    }
}
