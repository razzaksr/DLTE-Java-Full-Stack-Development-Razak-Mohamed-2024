package database.dlte;

import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Insertion {
    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    public static void insertRecords(MyBankUsers myBankUsers){
        Driver driver=new OracleDriver();
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query="insert into mybank_users values(?,?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1, myBankUsers.getUsername());
            preparedStatement.setString(2, myBankUsers.getPassword());
            preparedStatement.setString(3, myBankUsers.getEmail());
            preparedStatement.setLong(4,myBankUsers.getContact());
            preparedStatement.setDouble(5,myBankUsers.getBalance());
            int records = preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        MyBankUsers myBankUsers=new MyBankUsers();
        System.out.println("Enter the user details such as username, password, email, contact, balance");
        myBankUsers.setUsername(scanner.next());
        myBankUsers.setPassword(scanner.next());
        myBankUsers.setEmail(scanner.next());
        myBankUsers.setContact(scanner.nextLong());
        myBankUsers.setBalance(scanner.nextDouble());
        Insertion.insertRecords(myBankUsers);
    }
}
