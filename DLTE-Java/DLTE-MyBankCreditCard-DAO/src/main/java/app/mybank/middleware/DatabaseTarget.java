package app.mybank.middleware;

import app.mybank.remotes.CreditCardRepository;
import app.mybank.remotes.StorageTarget;
import app.mybank.remotes.TransactionRepository;
import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseTarget implements StorageTarget {

    private ResourceBundle resourceBundle=ResourceBundle.getBundle("database");
    private Connection connection;
    public DatabaseTarget(){
        try{
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    @Override
    public CreditCardRepository getCreditCardRepository() {
        return new CreditCardDatabaseRepository(connection);
    }

    @Override
    public TransactionRepository getTransactionRepository() {
        return null;
    }
}
