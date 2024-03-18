package myapp.service.soap;

import app.mybank.entity.CreditCard;
import app.mybank.services.CreditCardServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import web.CreditCardSoap;
import web.GroupOfCards;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    @Mock
    private CreditCardServices cardServices;

    private CreditCardSoap soapService;

    @Before
    public void setiingUp(){
        soapService=new CreditCardSoap();
        soapService.services=cardServices;
    }

    @Test
    public void testApproval(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");
        doNothing().when(cardServices).callSave(creditCard1);
        soapService.createCard(creditCard1);
        verify(cardServices,times(1)).callSave(creditCard1);
//        verify(cardServices,times(1)).callSave(creditCard2);
    }

    @Test
    public void testAllByLimit(){
        Integer limit=52000;
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> expectedList1= Stream.of(creditCard2,creditCard3).collect(Collectors.toList());
        List<CreditCard> expectedList2= Stream.of(creditCard1,creditCard4).collect(Collectors.toList());
        when(cardServices.callFindAllByLimit(limit)).thenReturn(expectedList2);

        GroupOfCards groupOfCards=soapService.readAllByLimit(limit);

//        assertNull(groupOfCards);
        assertNotNull(groupOfCards);
        assertEquals(11111122343L,groupOfCards.getCreditCards().get(0).getCardNumber().longValue());
//        assertEquals(45623536435L,groupOfCards.getCreditCards().get(1).getCardNumber().longValue());2
    }

}