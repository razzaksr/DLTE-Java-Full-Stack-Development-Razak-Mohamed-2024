package servlet.tests;

import app.mybank.entity.CreditCard;
import app.mybank.services.CreditCardServices;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import rest.endpoint.ModifyService;
import rest.endpoint.ReadAllByLimitService;
import rest.endpoint.ReadAllService;
import rest.endpoint.ReadByIdService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EndpointTest {
    @Mock
    private CreditCardServices services;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private StringWriter stringWriter;
    @Mock
    private PrintWriter printWriter;

    @Before
    public void initiate() throws IOException {
        stringWriter=new StringWriter();
        printWriter=new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
    }

    //@Test
//    public void testCreate() throws IOException, ServletException {
//        ModifyService modifyService=new ModifyService();
//        modifyService.init();
//        modifyService.cardServices=services;
//        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
//        CreditCard creditCard2=new CreditCard(11111122353L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
////        when(request.getReader()).then("{\"cardNumber\":11111122343,\"cardCvv\":383,\"cardExpiry\":\"Dec 2, 2029 12:00:00 AM\",\"cardLimit\":91000,\"cardAvailable\":10000,\"cardUsage\":81000,\"cardPin\":1111,\"cardStatus\":false,\"cardHolder\":\"Annapoorna Pai\"}");
//        Gson gson = new Gson();
//        String jsonCreditCard = gson.toJson(creditCard1);
//
//        // Mock request and response
//        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(jsonCreditCard)));
//        //doNothing().when(services).callSave(creditCard2);
//        modifyService.doPost(request,response);
//        verify(response).setContentType("application/json");
////        verify(services).callSave(creditCard1);
//        verify(response).setStatus(HttpServletResponse.SC_OK);
//        //assertEquals("Credit card has approved by MyBank",stringWriter.toString().trim());
//    }

    @Test
    public void testReadById() throws ServletException, IOException {
        ReadByIdService readByIdService=new ReadByIdService();
        readByIdService.creditCardServices=services;

        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");

        when(request.getParameter("number")).thenReturn("45623536435");

        when(services.callFindById(anyLong())).thenReturn(creditCard3);

        readByIdService.doGet(request,response);

        verify(response).setContentType("application/json");

        verify(services).callFindById(anyLong());

        assertEquals("{\"cardNumber\":11111122343,\"cardCvv\":383,\"cardExpiry\":\"Dec 2, 2029 12:00:00 AM\",\"cardLimit\":91000,\"cardAvailable\":10000,\"cardUsage\":81000,\"cardPin\":1111,\"cardStatus\":false,\"cardHolder\":\"Annapoorna Pai\"}",stringWriter.toString().trim());
//        assertEquals("{\"cardNumber\":45623536435,\"cardCvv\":564,\"cardExpiry\":\"Sep 28, 2030 12:00:00 AM\",\"cardLimit\":50000,\"cardAvailable\":20000,\"cardUsage\":30000,\"cardPin\":1384,\"cardStatus\":true,\"cardHolder\":\"Divija\"}",stringWriter.toString().trim());
    }

    @Test
    public void testReadAllByLimit() throws ServletException, IOException {
        ReadAllByLimitService readAllByLimitService=new ReadAllByLimitService();
        readAllByLimitService.creditCardServices=services;

        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> creditCards= Stream.of(creditCard2,creditCard4).collect(Collectors.toList());

        when(request.getParameter("limit")).thenReturn("52000");

        when(services.callFindAllByLimit(anyInt())).thenReturn(creditCards);

        readAllByLimitService.doGet(request,response);

        verify(response).setContentType("application/json");
        verify(services).callFindAllByLimit(anyInt());
        assertEquals("[{\"cardNumber\":98767767673,\"cardCvv\":123,\"cardExpiry\":\"Oct 4, 2034 12:00:00 AM\",\"cardLimit\":35000,\"cardAvailable\":10000,\"cardUsage\":25000,\"cardPin\":9874,\"cardStatus\":true,\"cardHolder\":\"Varun Raj\"},{\"cardNumber\":87673448747,\"cardCvv\":445,\"cardExpiry\":\"Aug 12, 2031 12:00:00 AM\",\"cardLimit\":200000,\"cardAvailable\":150000,\"cardUsage\":50000,\"cardPin\":9474,\"cardStatus\":true,\"cardHolder\":\"Akash\"}]",stringWriter.toString().trim());
    }
    @Test
    public void testReadAll() throws ServletException, IOException {
        ReadAllService readAllService=new ReadAllService();
        // setting mock service
        readAllService.creditCardServices=services;

        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> creditCards= Stream.of(creditCard1,creditCard2,creditCard3,creditCard4).collect(Collectors.toList());
        //System.out.println(creditCards.toString());

        when(services.callFindAll()).thenReturn(creditCards);

        readAllService.doGet(request,response);

        verify(response).setContentType("application/json");

        verify(services).callFindAll();

        //assertEquals("Expected result","[{\"cardNumber\":11111122343,\"cardCvv\":383,\"cardExpiry\":\"Dec 2, 2029 12:00:00 AM\",\"cardLimit\":91000,\"cardAvailable\":10000,\"cardUsage\":81000,\"cardPin\":1111,\"cardStatus\":false,\"cardHolder\":\"Annapoorna Pai\"},{\"cardNumber\":98767767673,\"cardCvv\":123,\"cardExpiry\":\"Oct 4, 2034 12:00:00 AM\",\"cardLimit\":35000,\"cardAvailable\":10000,\"cardUsage\":25000,\"cardPin\":9874,\"cardStatus\":true,\"cardHolder\":\"Varun Raj\"},{\"cardNumber\":45623536435,\"cardCvv\":564,\"cardExpiry\":\"Sep 28, 2030 12:00:00 AM\",\"cardLimit\":50000,\"cardAvailable\":20000,\"cardUsage\":30000,\"cardPin\":1384,\"cardStatus\":true,\"cardHolder\":\"Divija\"},{\"cardNumber\":87673448747,\"cardCvv\":445,\"cardExpiry\":\"Aug 12, 2031 12:00:00 AM\",\"cardLimit\":200000,\"cardAvailable\":150000,\"cardUsage\":50000,\"cardPin\":9474,\"cardStatus\":true,\"cardHolder\":\"Akash\"}]",stringWriter.toString().trim());
        assertEquals("Expected result","[{\"cardNumber\":98767767673,\"cardCvv\":123,\"cardExpiry\":\"Oct 4, 2034 12:00:00 AM\",\"cardLimit\":35000,\"cardAvailable\":10000,\"cardUsage\":25000,\"cardPin\":9874,\"cardStatus\":true,\"cardHolder\":\"Varun Raj\"},{\"cardNumber\":45623536435,\"cardCvv\":564,\"cardExpiry\":\"Sep 28, 2030 12:00:00 AM\",\"cardLimit\":50000,\"cardAvailable\":20000,\"cardUsage\":30000,\"cardPin\":1384,\"cardStatus\":true,\"cardHolder\":\"Divija\"},{\"cardNumber\":87673448747,\"cardCvv\":445,\"cardExpiry\":\"Aug 12, 2031 12:00:00 AM\",\"cardLimit\":200000,\"cardAvailable\":150000,\"cardUsage\":50000,\"cardPin\":9474,\"cardStatus\":true,\"cardHolder\":\"Akash\"}]",stringWriter.toString().trim());
    }
}
