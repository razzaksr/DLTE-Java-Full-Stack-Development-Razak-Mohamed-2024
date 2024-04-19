package servlets.web;

import app.mybank.entity.CreditCard;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ViewAllCreditCards extends HttpServlet {

    public CreditCardServices creditCardServices;

    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget=new DatabaseTarget();
        creditCardServices=new CreditCardServices(storageTarget);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CreditCard> myBankCard = creditCardServices.callFindAll();
        RequestDispatcher dispatcher=req.getRequestDispatcher("viewCards.jsp");
        req.setAttribute("myCards", myBankCard);
        dispatcher.include(req, resp);
    }
}
