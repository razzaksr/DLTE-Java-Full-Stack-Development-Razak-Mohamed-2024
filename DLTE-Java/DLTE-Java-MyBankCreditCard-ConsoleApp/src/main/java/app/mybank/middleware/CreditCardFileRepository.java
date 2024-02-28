package app.mybank.middleware;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.remotes.CreditCardRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreditCardFileRepository implements CreditCardRepository {

    private String filePath;
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("creditcard");
    private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private List<CreditCard> creditCardList=new ArrayList<>();
    public CreditCardFileRepository(String url){
        filePath=url;
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
        CreditCard object=creditCardList.stream().filter(each->each.getCardNumber()== creditCard.getCardNumber()).findFirst().orElse(null);
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
        CreditCard object=creditCardList.stream().filter(each->each.getCardNumber()==creditCardNumber).findFirst().orElse(null);
        if(object==null) {
            logger.log(Level.WARNING,creditCardNumber+resourceBundle.getString("card.notExists"));
            throw new CreditCardException();
        }
        return object;
    }

    @Override
    public List<CreditCard> findAllByLimit(Integer limit) {
        return null;
    }

    @Override
    public void update(CreditCard creditCard) {

    }

    @Override
    public void delete(CreditCard creditCard) {

    }
}
