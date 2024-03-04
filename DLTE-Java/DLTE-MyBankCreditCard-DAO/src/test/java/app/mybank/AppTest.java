package app.mybank;

import app.mybank.entity.CreditCard;
import app.mybank.remotes.CreditCardRepository;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.CreditCardServices;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest{
    @Mock
    private StorageTarget mockStorageTarget;
    @Mock
    private CreditCardRepository mockCreditCardRepository;
    private CreditCardServices services;
    @Before
    public void prepareStore(){
        when(mockStorageTarget.getCreditCardRepository()).thenReturn(mockCreditCardRepository);
        services=new CreditCardServices(mockStorageTarget);
    }

    @Test
    public void testDelete(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");

        doNothing().when(mockCreditCardRepository).delete(creditCard1);

        services.callDelete(creditCard1);

        verify(mockCreditCardRepository).delete(creditCard1);
    }

    @Test
    public void testUpdate(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");

        doNothing().when(mockCreditCardRepository).update(creditCard2);

//        services.callUpdate(creditCard1);
        services.callUpdate(creditCard2);

        verify(mockCreditCardRepository).update(creditCard2);
    }

    @Test
    public void testSave(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");

        doNothing().when(mockCreditCardRepository).save(creditCard1);

        services.callSave(creditCard1);

//        verify(mockCreditCardRepository).save(creditCard2);
        verify(mockCreditCardRepository).save(creditCard1);
    }

    @Test
    public void testFindAllByLimit(){
        Integer limit1=50001;
        Integer limit2=100001;
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),35000,10000,25000,9874,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> expectedList1= Stream.of(creditCard2,creditCard3).collect(Collectors.toList());
        List<CreditCard> expectedList2= Stream.of(creditCard1,creditCard4).collect(Collectors.toList());

        when(mockCreditCardRepository.findAllByLimit(limit1)).thenReturn(expectedList1);

        List<CreditCard> actualList=services.callFindAllByLimit(limit1);

//        assertNull(actualList);
        assertEquals(expectedList1.get(0).getCardHolder(),actualList.get(0).getCardHolder());
    }

    @Test
    public void testFindById(){
        Long cardNumber1=45623536435L;
        Long cardNumber2=11111122343L;

        CreditCard creditCard1=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard2=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");

        when(mockCreditCardRepository.findById(cardNumber2)).thenReturn(creditCard2);

        CreditCard actualCreditCard = services.callFindById(cardNumber2);

        assertNotSame(creditCard1.getCardHolder(),actualCreditCard.getCardHolder());
        assertEquals(creditCard2.getCardNumber(),actualCreditCard.getCardNumber());
    }

    @Test
    public void testFindAll(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),100000,90000,10000,9874,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> expectedList= Stream.of(creditCard2,creditCard3,creditCard4).collect(Collectors.toList());

        when(mockCreditCardRepository.findAll()).thenReturn(expectedList);

        List<CreditCard> actualList = services.callFindAll();

        assertSame(3,actualList.size());
        //assertEquals(creditCard1.getCardHolder(),actualList.get(0).getCardHolder());
        assertTrue(actualList.get(1).isCardStatus());
    }
}
