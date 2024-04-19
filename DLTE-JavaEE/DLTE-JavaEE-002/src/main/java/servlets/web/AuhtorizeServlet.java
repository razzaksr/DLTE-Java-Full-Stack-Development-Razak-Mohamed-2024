package servlets.web;

import app.mybank.middleware.CreditCardDatabaseRepository;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;
import oracle.jdbc.OracleDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.endpoint.ReadByIdService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.ResourceBundle;

@WebServlet("/authorize")
public class AuhtorizeServlet extends HttpServlet {
    public CreditCardServices cardServices;
    public ResourceBundle resourceBundle;
    public Logger logger;
    public CreditCardDatabaseRepository repository;
    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget=new DatabaseTarget();
        cardServices=new CreditCardServices(storageTarget);
        resourceBundle=ResourceBundle.getBundle("exception");
        logger= LoggerFactory.getLogger(ReadByIdService.class);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query = "select * from mybank_users where username=? and password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                HttpSession session=req.getSession();
                session.setAttribute("username",username);
                resp.sendRedirect("dashboard.jsp");
            }
            else{
                resp.sendRedirect("index.jsp");
            }
        } catch (SQLException var2) {
            SQLException sqlException = var2;
            System.out.println(sqlException);
        }
    }
}
