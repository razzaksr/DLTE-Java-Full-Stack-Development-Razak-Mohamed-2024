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

@WebServlet("/rest/id/*")
public class ReadByIdService extends HttpServlet {

    public CreditCardServices creditCardServices;
    private ResourceBundle resourceBundle;
    private Logger logger;

    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget=new DatabaseTarget();
        creditCardServices=new CreditCardServices(storageTarget);
        resourceBundle=ResourceBundle.getBundle("exception");
        logger= LoggerFactory.getLogger(ReadByIdService.class);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("number");
        resp.setContentType("application/json");
        try{
            Long creditCardNumber=Long.parseLong(id);
//            logger.info(resourceBundle.getString("id.number"));
            CreditCard creditCard = creditCardServices.callFindById(creditCardNumber);
            Gson gson=new Gson();
            String responseData = gson.toJson(creditCard);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(responseData);

        }
        catch (NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            //resp.getWriter().println(resourceBundle.getString("number.format"));
        }
        catch (CreditCardException | MissingResourceException creditCardException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            //resp.getWriter().println(resourceBundle.getString("card.not.found"));
        }
    }
}
