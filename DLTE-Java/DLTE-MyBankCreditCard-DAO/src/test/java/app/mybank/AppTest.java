package app.mybank;

import app.mybank.entity.CreditCard;
import app.mybank.middleware.CreditCardDatabaseRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    CreditCardDatabaseRepository repository;

    @Before
    public void initialize(){
        try{
            MockitoAnnotations.openMocks(this);
            repository=new CreditCardDatabaseRepository(connection);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(preparedStatement.executeUpdate()).thenReturn(1);
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    @Test
    public void testSave(){

    }
}
