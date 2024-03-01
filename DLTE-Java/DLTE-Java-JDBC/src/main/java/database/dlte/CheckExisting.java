package database.dlte;

import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.ResourceBundle;

public class CheckExisting {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            PreparedStatement preparedStatement= connection.prepareStatement("select table_name from all_tables");
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getObject(1));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
