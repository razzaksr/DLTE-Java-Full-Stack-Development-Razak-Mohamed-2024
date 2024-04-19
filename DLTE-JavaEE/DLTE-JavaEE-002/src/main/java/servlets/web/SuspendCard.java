package servlets.web;

import app.mybank.entity.CreditCard;
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
import java.util.ResourceBundle;

@WebServlet("/remove")
public class SuspendCard extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditCard card = creditCardServices.callFindById(Long.parseLong(req.getParameter("number")));
        creditCardServices.callDelete(card);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("view");
        requestDispatcher.forward(req, resp);
    }
}
