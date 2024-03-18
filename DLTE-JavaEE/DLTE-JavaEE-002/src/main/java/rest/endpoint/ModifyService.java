package rest.endpoint;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@WebServlet("/rest/")
public class ModifyService extends HttpServlet {
    public CreditCardServices cardServices;
    public ResourceBundle resourceBundle;
    public Logger logger;
    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget=new DatabaseTarget();
        cardServices=new CreditCardServices(storageTarget);
        resourceBundle=ResourceBundle.getBundle("exception");
        logger= LoggerFactory.getLogger(ReadByIdService.class);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try{
            Gson gson=new Gson();
            CreditCard creditCard = gson.fromJson(req.getReader(), CreditCard.class);
            cardServices.callSave(creditCard);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(resourceBundle.getString("card.saved"));
        }
        catch(NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(numberFormatException);
        }
        catch (CreditCardException creditCardException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(resourceBundle.getString("card.not.found"));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try{
            Gson gson=new Gson();
            CreditCard creditCard = gson.fromJson(req.getReader(), CreditCard.class);
            cardServices.callUpdate(creditCard);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(resourceBundle.getString("card.updated"));
        }
        catch(NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(numberFormatException);
        }
        catch (CreditCardException creditCardException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(resourceBundle.getString("card.not.found"));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try{
            Gson gson=new Gson();
            CreditCard creditCard = gson.fromJson(req.getReader(), CreditCard.class);
            cardServices.callDelete(creditCard);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(resourceBundle.getString("card.deleted"));
        }
        catch(NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(numberFormatException);
        }
        catch (CreditCardException | MissingResourceException creditCardException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(resourceBundle.getString("card.not.found"));
        }
    }
}
