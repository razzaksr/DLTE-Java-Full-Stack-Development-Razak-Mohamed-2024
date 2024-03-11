package first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "MyFirstServlet",value = "/first/api/")
@WebServlet("/first/api/*")
public class MyFirstServlet extends HttpServlet {
    Logger logger;
    @Override
    public void destroy() {
        logger.info("Servlet's Destroy has executed");
    }

    @Override
    public void init() throws ServletException {
        logger= LoggerFactory.getLogger(MyFirstServlet.class);
        logger.info("Servlet Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Servlet's GET has executed");
        String path=req.getPathInfo();
        if(path==null||path.equals("/"))
            logger.info("Servlet's GET has executed");
        else {
            String data = path.substring(1);
            logger.info(data);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Servlet's POST has executed");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Servlet's PUT has executed");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Servlet's DELETE has executed");
    }
}
