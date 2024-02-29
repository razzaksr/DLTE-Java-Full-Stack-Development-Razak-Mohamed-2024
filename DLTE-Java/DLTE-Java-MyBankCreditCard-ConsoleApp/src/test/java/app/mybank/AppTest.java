package app.mybank;

import app.mybank.entity.CreditCard;
import app.mybank.exceptions.CreditCardException;
import app.mybank.middleware.CreditCardFileRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    static String testFilePath="test-credit.doc";
    static List<CreditCard> creditCardList;

    CreditCardFileRepository repository=new CreditCardFileRepository(testFilePath);
    @BeforeClass
    public static void initialize(){
        creditCardList = Stream.of(
                new CreditCard(1234567890L, 123,new Date("2/28/2033"), 100000, 20000, 80000, 1234, true, "Ankita"),
                new CreditCard(9876543210L, 763,new Date("10/29/2029"), 50000, 30000, 20000, 8764, true, "Nishmitha"),
                new CreditCard(2233445566L, 982,new Date("4/10/2027"), 20000, 10000, 10000, 8445, true, "Medhini")
        ).collect(Collectors.toList());
        try{
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(testFilePath));
            objectOutputStream.writeObject(creditCardList);
            objectOutputStream.close();
        }
        catch (IOException ioException){}
    }

    @Test
    public void testFetch(){
        assertSame(3,repository.findAll().size());
//        assertNotEquals(Optional.of(2233445566L), Optional.ofNullable(repository.findById(2233445566L).getCardNumber()));
    }

    @Test(expected = CreditCardException.class)
    public void testSave(){
        CreditCard creditCard=new CreditCard(2233445566L, 982,new Date("4/10/2027"), 20000, 10000, 10000, 8445, true, "Varun");
        repository.save(creditCard);
//        assertThrows(CreditCardException.class,repository.save(creditCard));
    }

    @Test
    public void testSave1(){
        CreditCard creditCard=new CreditCard(1133445566L, 982,new Date("4/10/2027"), 20000, 10000, 10000, 8445, true, "Varun");
        repository.save(creditCard);
        assertTrue(repository.findById(1133445566L).getCardNumber().equals(1133445566L));
    }
}
