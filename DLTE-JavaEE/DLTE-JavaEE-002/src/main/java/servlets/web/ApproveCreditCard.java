package servlets.web;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.endpoint.ReadByIdService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

@WebServlet("/approve")
public class ApproveCreditCard extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Approve servlet invoked");
        long cardNumber = Long.parseLong(req.getParameter("cardNumber"));
        int cardCvv = Integer.parseInt(req.getParameter("cardCvv"));
        String cardExpiry = req.getParameter("cardExpiry");

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date sourceDate = formatter.parse(cardExpiry);
            formatter=new SimpleDateFormat("MM/dd/yyyy");
            cardExpiry = formatter.format(sourceDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int cardLimit = Integer.parseInt(req.getParameter("cardLimit"));
        int cardAvail = Integer.parseInt(req.getParameter("cardAvailable"));
        int cardUsage = Integer.parseInt(req.getParameter("cardUsage"));
        String cardStatus = req.getParameter("cardStatus");
        logger.info(cardStatus);
        boolean status = Boolean.parseBoolean(cardStatus);
        String cardHolderName = req.getParameter("cardHolder");
        int cardPin = Integer.parseInt(req.getParameter("cardPin"));
        CreditCard creditCard=new CreditCard(cardNumber,cardCvv,new Date(cardExpiry),cardLimit,cardAvail,cardUsage,cardPin,status,cardHolderName);
        RequestDispatcher dispatcher=req.getRequestDispatcher("approveCard.jsp");
        try{
            cardServices.callSave(creditCard);
            req.setAttribute("info",resourceBundle.getString("card.saved"));
        }
        catch (NumberFormatException numberFormatException){
            req.setAttribute("error",numberFormatException);
        }
        catch (CreditCardException creditCardException){
            req.setAttribute("error",resourceBundle.getString("card.not.found"));
        }
        dispatcher.forward(req, resp);
    }
}
