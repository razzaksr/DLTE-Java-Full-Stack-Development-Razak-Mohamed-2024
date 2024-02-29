package app.mybank.middleware;

import app.mybank.entity.CreditCard;
import app.mybank.entity.Merchant;
import app.mybank.entity.Transaction;
import app.mybank.exceptions.TransactionException;
import app.mybank.remotes.TransactionRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TransactionFileRepository implements TransactionRepository {

    private CreditCardFileRepository creditCardFileRepository=new CreditCardFileRepository("mybank-creditcard.doc");

    private String transactionFilePath, merchantFilePath;
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("transaction");

    private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private List<Transaction> transactionList=new ArrayList<>();
    private List<Merchant> merchantList=new ArrayList<>();

    public TransactionFileRepository(String transactionUrl, String merchantUrl){
        transactionFilePath=transactionUrl;
        merchantFilePath=merchantUrl;
        try{
            FileHandler fileHandler=new FileHandler("transaction-logs.txt",true);
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        }
        catch (IOException ioException){}
    }

    private void writeIntoTransactionFile(){
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(transactionFilePath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(transactionList);

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ioException){}
    }

    private void readFromTransactionFile(){
        try{
            FileInputStream fileInputStream=new FileInputStream(transactionFilePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            transactionList=(List<Transaction>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException | ClassNotFoundException ioException){}
    }
    private void writeIntoMerchantFile(){
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(merchantFilePath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(merchantList);

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ioException){}
    }

    private void readFromMerchantFile(){
        try{
            FileInputStream fileInputStream=new FileInputStream(merchantFilePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            merchantList=(List<Merchant>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException | ClassNotFoundException ioException){}
    }

    @Override
    public void save(Transaction transaction, String merchantName) {
        readFromTransactionFile();
        int lastIndex=transactionList.size()-1;
        CreditCard creditCard=creditCardFileRepository.findById(transaction.getTransactionDoneBy());
        try{
            if(creditCard.getCardAvailable()>=transaction.getTransactionAmount()){
                int existingId=transactionList.get(lastIndex).getTransactionId();
                transaction.setTransactionId(existingId+1);


                readFromMerchantFile();
                Merchant merchantObject=merchantList.stream().filter(each->each.getMerchantId().equals(transaction.getMerchant())).findFirst().orElse(null);
                if(merchantObject==null) {
                    Merchant newMerchant=new Merchant(transaction.getMerchant(), merchantName);
                    merchantList.add(newMerchant);
                    writeIntoMerchantFile();
                    logger.log(Level.INFO,resourceBundle.getString("merchant.new"));
                    System.out.println(resourceBundle.getString("merchant.new"));
                }

                double available= (creditCard.getCardAvailable()- transaction.getTransactionAmount());
                double usage = creditCard.getCardUsage()+ transaction.getTransactionAmount();
                creditCard.setCardAvailable((int) available);
                creditCard.setCardUsage((int) usage);
                creditCardFileRepository.update(creditCard);
                transactionList.add(transaction);
                writeIntoTransactionFile();
                logger.log(Level.INFO,resourceBundle.getString("transaction.ok"));
                System.out.println(resourceBundle.getString("transaction.ok"));
            }
            else{
                throw new TransactionException(resourceBundle.getString("transaction.failed.limit"));
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){

            transaction.setTransactionId(11021);
            readFromMerchantFile();
            Merchant merchantObject=merchantList.stream().filter(each->each.getMerchantId().equals(transaction.getMerchant())).findFirst().orElse(null);
            if(merchantObject==null) {
                Merchant newMerchant=new Merchant(transaction.getMerchant(), merchantName);
                merchantList.add(newMerchant);
                writeIntoMerchantFile();
                logger.log(Level.INFO,resourceBundle.getString("merchant.new"));
                System.out.println(resourceBundle.getString("merchant.new"));
            }

            double available= (creditCard.getCardAvailable()- transaction.getTransactionAmount());
            double usage = creditCard.getCardUsage()+ transaction.getTransactionAmount();
            creditCard.setCardAvailable((int) available);
            creditCard.setCardUsage((int) usage);
            creditCardFileRepository.update(creditCard);
            transactionList.add(transaction);
            writeIntoTransactionFile();
            logger.log(Level.INFO,resourceBundle.getString("transaction.ok"));
            System.out.println(resourceBundle.getString("transaction.ok"));
        }
    }

    @Override
    public List<Transaction> findAll() {
        readFromTransactionFile();
        readFromMerchantFile();
        if(transactionList.size()==0){
            logger.log(Level.WARNING,resourceBundle.getString("transaction.empty"));
            System.out.println(resourceBundle.getString("transaction.empty"));
        }
        System.out.println(merchantList);
        return transactionList;
    }

    @Override
    public List<Transaction> findAllByCreditCard(Long cardNumber) {
        return null;
    }

    @Override
    public List<Transaction> findAllByDate(Date date) {
        return null;
    }

    @Override
    public List<Transaction> findAllByMerchant(Integer merchantId) {
        return null;
    }

    @Override
    public void saveMerchant(Merchant merchant) {

    }
}
