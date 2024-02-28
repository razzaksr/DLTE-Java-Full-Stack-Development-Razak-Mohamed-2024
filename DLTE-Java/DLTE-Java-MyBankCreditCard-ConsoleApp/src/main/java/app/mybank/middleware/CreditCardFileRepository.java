package app.mybank.middleware;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.remotes.CreditCardRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class CreditCardFileRepository implements CreditCardRepository {

    private String filePath;
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("creditcard");
    private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private List<CreditCard> creditCardList=new ArrayList<>();
    public CreditCardFileRepository(String url){
        filePath=url;
        try{
            FileHandler fileHandler=new FileHandler("credit-card-logs.txt",true);
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        }
        catch (IOException ioException){}
    }

    private void writeIntoFile(){
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(creditCardList);

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ioException){}
    }

    private void readFromFile(){
        try{
            FileInputStream fileInputStream=new FileInputStream(filePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            creditCardList=(List<CreditCard>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException | ClassNotFoundException ioException){}
    }

    @Override
    public void save(CreditCard creditCard) {
        readFromFile();
        CreditCard object=creditCardList.stream().filter(each->each.getCardNumber().equals(creditCard.getCardNumber())).findFirst().orElse(null);
        if(object!=null) {
            logger.log(Level.WARNING,creditCard.getCardNumber()+resourceBundle.getString("card.exists"));
            throw new CreditCardException();
        }
        creditCardList.add(creditCard);
        writeIntoFile();
        logger.log(Level.INFO,creditCard.getCardNumber()+resourceBundle.getString("card.saved"));
        System.out.println(creditCard.getCardNumber()+resourceBundle.getString("card.saved"));
    }

    @Override
    public List<CreditCard> findAll() {
        readFromFile();
        logger.log(Level.INFO,resourceBundle.getString("card.everything"));
        return creditCardList;
    }

    @Override
    public CreditCard findById(Long creditCardNumber) {
        readFromFile();
        CreditCard object=creditCardList.stream().filter(each->each.getCardNumber().equals(creditCardNumber)).findFirst().orElse(null);
        if(object==null) {
            logger.log(Level.WARNING,creditCardNumber+resourceBundle.getString("card.notExists"));
            throw new CreditCardException();
        }
        return object;
    }

    @Override
    public List<CreditCard> findAllByLimit(Integer limit) {
        readFromFile();
        creditCardList=creditCardList.stream().filter(each->each.getCardLimit().compareTo(limit)>0).collect(Collectors.toList());
        if(creditCardList.size()==0) {
            logger.log(Level.WARNING, limit.toString() + resourceBundle.getString("card.notExists"));
            throw new CreditCardException(resourceBundle.getString("card.noMatches"));
        }
        return creditCardList;
    }

    @Override
    public void update(CreditCard creditCard) {
        readFromFile();
        CreditCard matched = creditCardList.stream().filter(each->each.getCardNumber().equals(creditCard.getCardNumber())).findFirst().orElse(null);
        if(matched==null) {
            logger.log(Level.WARNING,creditCard.getCardNumber()+resourceBundle.getString("card.notExists"));
            throw new CreditCardException(resourceBundle.getString("card.noMatches"));
        }
        int index=creditCardList.indexOf(matched);
        creditCardList.set(index,creditCard);
        writeIntoFile();
        logger.log(Level.FINE,resourceBundle.getString("card.update.ok"));
        System.out.println(resourceBundle.getString("card.update.ok"));
    }

    @Override
    public void delete(CreditCard creditCard) {
        readFromFile();
        boolean removeStatus=creditCardList.removeIf(each->each.getCardNumber().equals(creditCard.getCardNumber()));
        if(!removeStatus){
            logger.log(Level.WARNING,creditCard.getCardNumber()+resourceBundle.getString("card.noMatches"));
            throw new CreditCardException(resourceBundle.getString("card.noMatches"));
        }
        writeIntoFile();
        logger.log(Level.FINE,resourceBundle.getString("card.delete.ok"));
        System.out.println(resourceBundle.getString("card.delete.ok"));
    }
}
