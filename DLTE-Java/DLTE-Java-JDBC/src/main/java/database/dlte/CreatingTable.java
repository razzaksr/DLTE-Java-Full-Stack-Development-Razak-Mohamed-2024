package database.dlte;

import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.ResourceBundle;

public class CreatingTable {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Driver driver=new OracleDriver();
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query="create table mybank_users(username varchar(255) primary key, password varchar(255), email varchar(255), contact number, balance number )";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            boolean acknowledge = preparedStatement.execute();
            System.out.println("Table has created");
            connection.close();
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
}
