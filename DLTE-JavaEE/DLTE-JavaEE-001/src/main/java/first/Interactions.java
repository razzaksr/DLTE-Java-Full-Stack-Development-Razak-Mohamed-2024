package first;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BasicInteractions",value="/second/*")
public class Interactions extends HttpServlet {
    int[][] schemes={{12000,4500,1000},{9800,5600},{45000,100000,200,76000}};
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPrinciple = req.getParameter("principle");
        String requestTenure = req.getParameter("tenure");

        //System.out.println(requestPrinciple+" "+requestTenure);

        String requestSearch=req.getParameter("search");

        if(requestPrinciple!=null&&requestTenure!=null){
            int principle = Integer.parseInt(requestPrinciple);
            int tenure = Integer.parseInt(requestTenure);
            double totalRepayment=0.0, EMI=0.0;
            if(principle>=100000&&principle<=300000){
                totalRepayment=principle+(principle*0.240);
            }
            else if(principle>300000&&principle<=500000){
                totalRepayment=principle+(principle*0.250);
            }
            else{
                totalRepayment=principle+(principle*0.290);
            }
            EMI=totalRepayment/tenure;

            resp.setContentType("application/json");
            Gson gson=new Gson();
            //String message = gson.toJson(EMI);
            //resp.getWriter().println(message);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(EMI);
        }
        else{
            String received = search(Integer.parseInt(requestSearch));
            resp.getWriter().println(received);
        }
    }

    public String search(int users){
        int rowSize=schemes.length, columnSize=0;
        for(int row=0;row<rowSize;row++){
            columnSize=schemes[row].length;
            for(int column=0;column<columnSize;column++){
                if(schemes[row][column]==users){
                    String message="{data:"+users+",at-row:"+row+",at-column:"+column+"}";
                    return message;
                }
            }
        }
        return "{data:"+users+",status:Not found}";
    }
}
