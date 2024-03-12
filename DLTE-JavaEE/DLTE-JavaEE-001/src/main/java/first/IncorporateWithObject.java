package first;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/third/obj/*")
public class IncorporateWithObject extends HttpServlet {

    List<Loan> myBankLoans= Stream.of(new Loan(123,98000,new Date("3/30/2024"),"open","Ankitha"),
            new Loan(844,122400,new Date("1/20/2024"),"open","Nishmitha"),
            new Loan(495,87440,new Date("11/12/2024"),"closed","Eeksha"),
            new Loan(132,35000,new Date("5/31/2024"),"open","Annapoorna")).collect(Collectors.toList());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();
        resp.setContentType("application/json");
        String json = gson.toJson(myBankLoans);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();

        Loan loan = gson.fromJson(req.getReader(),Loan.class);
        myBankLoans.add(loan);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(loan.getLoanBorrower()+" has added to the records");
    }
}
