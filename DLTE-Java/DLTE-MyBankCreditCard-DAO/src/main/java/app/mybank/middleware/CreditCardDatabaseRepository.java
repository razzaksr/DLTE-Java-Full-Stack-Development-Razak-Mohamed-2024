package app.mybank.middleware;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.remotes.CreditCardRepository;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CreditCardDatabaseRepository implements CreditCardRepository {
    private Connection connection;
    private List<CreditCard> creditCardList=new ArrayList<>();

    private ResourceBundle resourceBundle=ResourceBundle.getBundle("database");
    private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CreditCardDatabaseRepository(Connection connection){
        try{
            this.connection=connection;
            FileHandler fileHandler=new FileHandler("credit-card-logs.txt",true);
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        }
        catch (IOException ioException){
            System.out.println(ioException);
        }
    }

    @Override
    public void save(CreditCard creditCard) {
        try{
            String query="insert into mybank_creditcard values(?,?,?,?,?,?,?,?,?)";
            preparedStatement= connection.prepareStatement(query);

            preparedStatement.setLong(1,creditCard.getCardNumber());
            preparedStatement.setInt(2,creditCard.getCardCvv());
            preparedStatement.setDate(3,new Date(creditCard.getCardExpiry().getTime()));
            preparedStatement.setInt(4,creditCard.getCardPin());
            preparedStatement.setInt(5,creditCard.getCardLimit());
            preparedStatement.setInt(6,creditCard.getCardUsage());
            preparedStatement.setInt(7,creditCard.getCardAvailable());
            preparedStatement.setBoolean(8,creditCard.isCardStatus());
            preparedStatement.setString(9,creditCard.getCardHolder());

            int result = preparedStatement.executeUpdate();
            if(result!=0){
                logger.log(Level.INFO,resourceBundle.getString("record.push.ok"));
                System.out.println(resourceBundle.getString("record.push.ok"));
            }
            else{
                logger.log(Level.INFO,resourceBundle.getString("record.push.fail"));
                System.out.println(resourceBundle.getString("record.push.fail"));
            }
        }
        catch (SQLException sqlException){
            System.out.println(resourceBundle.getString("card.not.ok"));
        }
    }

    @Override
    public List<CreditCard> findAll() {
        try{
            String query="select * from mybank_creditcard";
            preparedStatement=connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            creditCardList=new ArrayList<>();
            CreditCard creditCard=null;
            while(resultSet.next()){
                creditCard=new CreditCard();
                creditCard.setCardNumber(resultSet.getLong(1));
                creditCard.setCardCvv(resultSet.getInt(2));
                creditCard.setCardExpiry(resultSet.getDate(3));
                creditCard.setCardPin(resultSet.getInt(4));
                creditCard.setCardLimit(resultSet.getInt(5));
                creditCard.setCardUsage(resultSet.getInt(6));
                creditCard.setCardAvailable(resultSet.getInt(7));
                creditCard.setCardStatus(resultSet.getBoolean(8));
                creditCard.setCardHolder(resultSet.getString(9));
                creditCardList.add(creditCard);
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return creditCardList;
    }

    @Override
    public CreditCard findById(Long creditCardNumber) {
        CreditCard creditCard=null;
        try{
            String query="select * from mybank_creditcard where creditcard_number=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setLong(1,creditCardNumber);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                creditCard=new CreditCard();
                creditCard.setCardNumber(resultSet.getLong(1));
                creditCard.setCardCvv(resultSet.getInt(2));
                creditCard.setCardExpiry(resultSet.getDate(3));
                creditCard.setCardPin(resultSet.getInt(4));
                creditCard.setCardLimit(resultSet.getInt(5));
                creditCard.setCardUsage(resultSet.getInt(6));
                creditCard.setCardAvailable(resultSet.getInt(7));
                creditCard.setCardStatus(resultSet.getBoolean(8));
                creditCard.setCardHolder(resultSet.getString(9));
            }
            else{
                logger.log(Level.INFO,resourceBundle.getString("card.no.id"));
                System.out.println(resourceBundle.getString("card.no.id"));
                throw new CreditCardException(resourceBundle.getString("card.no.id"));
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return creditCard;
    }

    @Override
    public List<CreditCard> findAllByLimit(Integer limit) {
        try{
            String query="select * from mybank_creditcard where creditcard_limit<?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,limit);
            resultSet = preparedStatement.executeQuery();
            creditCardList=new ArrayList<>();
            CreditCard creditCard=null;
            while(resultSet.next()){
                creditCard=new CreditCard();
                creditCard.setCardNumber(resultSet.getLong(1));
                creditCard.setCardCvv(resultSet.getInt(2));
                creditCard.setCardExpiry(resultSet.getDate(3));
                creditCard.setCardPin(resultSet.getInt(4));
                creditCard.setCardLimit(resultSet.getInt(5));
                creditCard.setCardUsage(resultSet.getInt(6));
                creditCard.setCardAvailable(resultSet.getInt(7));
                creditCard.setCardStatus(resultSet.getBoolean(8));
                creditCard.setCardHolder(resultSet.getString(9));
                creditCardList.add(creditCard);
            }
            if(creditCardList.size()==0)
                throw new CreditCardException();
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return creditCardList;
    }

    @Override
    public void update(CreditCard creditCard) {
        try{
            String query="update mybank_creditcard set creditcard_limit=?, creditcard_usage=?,creditcard_available=?,creditcard_pin=? where creditcard_number=?";
            preparedStatement=connection.prepareStatement(query);

            preparedStatement.setInt(1,creditCard.getCardLimit());
            preparedStatement.setInt(2,creditCard.getCardUsage());
            preparedStatement.setInt(3,creditCard.getCardAvailable());
            preparedStatement.setInt(4,creditCard.getCardPin());
            preparedStatement.setLong(5,creditCard.getCardNumber());

            int result = preparedStatement.executeUpdate();
            if(result!=0){
                logger.log(Level.INFO,resourceBundle.getString("card.update.ok"));
                System.out.println(resourceBundle.getString("card.update.ok"));
            }
            else{
                throw new CreditCardException(resourceBundle.getString("card.update.not.ok"));
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    @Override
    public void delete(CreditCard creditCard) {
        try{
            String query="delete from mybank_creditcard where creditcard_number=?";
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setLong(1,creditCard.getCardNumber());
            int result = preparedStatement.executeUpdate();
            if(result!=0){
                logger.log(Level.INFO,resourceBundle.getString("card.delete.ok"));
                System.out.println(resourceBundle.getString("card.delete.ok"));
            }
            else{
                throw new CreditCardException(resourceBundle.getString("card.delete.ok"));
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
}
