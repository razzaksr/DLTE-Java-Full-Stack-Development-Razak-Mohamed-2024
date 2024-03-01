package database.dlte;

import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Retrieval {
    private static Driver driver;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet records;
    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    static {
        try{
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
        }
        catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
    public static List<MyBankUsers> fetchRecords(){

        List<MyBankUsers> myBankUsersList=new ArrayList<>();
        try{
            String query="select * from mybank_users";
            preparedStatement= connection.prepareStatement(query);
            records = preparedStatement.executeQuery();
            MyBankUsers myBankUsers=null;
            while(records.next()){
                myBankUsers=new MyBankUsers();

                myBankUsers.setUsername(records.getString("username"));
                myBankUsers.setPassword(records.getString(2));
                myBankUsers.setEmail(records.getString("email"));
                myBankUsers.setContact(records.getLong("contact"));
                myBankUsers.setBalance(records.getDouble(5));
                myBankUsersList.add(myBankUsers);
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return myBankUsersList;
    }
    public static List<MyBankUsers> fetchRecordsByBalance(double min, double max){
        List<MyBankUsers> myBankUsersList=new ArrayList<>();
        try{
            String query="select * from mybank_users where balance between ? and ?";
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setDouble(1,min);
            preparedStatement.setDouble(2,max);
            records = preparedStatement.executeQuery();
            MyBankUsers myBankUsers=null;
            while(records.next()){
                myBankUsers=new MyBankUsers();

                myBankUsers.setUsername(records.getString("username"));
                myBankUsers.setPassword(records.getString(2));
                myBankUsers.setEmail(records.getString("email"));
                myBankUsers.setContact(records.getLong("contact"));
                myBankUsers.setBalance(records.getDouble(5));
                myBankUsersList.add(myBankUsers);
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return myBankUsersList;
    }

    public static void update(MyBankUsers myBankUsers){
        try{
            String query="update mybank_users set password=?, email=?, contact=?,balance=? where username=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, myBankUsers.getPassword());
            preparedStatement.setString(2, myBankUsers.getEmail());
            preparedStatement.setLong(3, myBankUsers.getContact());
            preparedStatement.setDouble(4, myBankUsers.getBalance());
            preparedStatement.setString(5, myBankUsers.getUsername());
            int result=preparedStatement.executeUpdate();
            if(result!=0){
                System.out.println(myBankUsers.getUsername()+" REcords are updated");
            }
            else{
                System.out.println(myBankUsers.getUsername()+" REcords aren't updated");
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    public static void delete(String userName){
        try{
            String query="delete from mybank_users where username=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            int result = preparedStatement.executeUpdate();
            if(result!=0){
                System.out.println(userName+" has deleted");
            }
            else{
                System.out.println(userName+" not available");
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Retrieval.fetchRecords());
        Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter the min and max balance to fetch");
//        System.out.println(Retrieval.fetchRecordsByBalance(scanner.nextDouble(), scanner.nextDouble()));
//        MyBankUsers myBankUsers=new MyBankUsers("sanathkumar","sanath@123","sanathkumar@gmail.com",87656787656L,100000.0);
//        update(myBankUsers);
        System.out.println("Tell us username wish to delete ");
        delete(scanner.next());
    }
}
