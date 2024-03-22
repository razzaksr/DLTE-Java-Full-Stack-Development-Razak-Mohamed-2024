package elements.spring.explore;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DlteSpring006JdbcApplicationTests {
	@Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private MyBankService myBankService;

    //@Test
    void testBlock(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),100000,90000,10000,9874,true,"Varun Raj");

        lenient().when(jdbcTemplate.update(anyString(),any(Object[].class))).thenReturn(1);

        String info = myBankService.apiBlock(creditCard1.getCreditcardNumber(), creditCard1.getCreditcardPin());

        assertEquals("11111122343 card is blocked",info);
        //assertEquals("11111122343 card is blocked",info);
    }

    //@Test
    void testApprove(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),100000,90000,10000,9874,true,"Varun Raj");
        lenient().when(jdbcTemplate.update(anyString(),any(Object[].class))).thenReturn(1);

        CreditCard actual = myBankService.apiSave(creditCard2);
//        System.out.println(actual.getCreditcardHolder());

//        assertEquals(creditCard1.getCreditcardHolder(),actual.getCreditcardHolder());
        assertFalse(creditCard1.isCreditcardStatus()==actual.isCreditcardStatus());
    }

    //@Test
    void testViewByLimit(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),100000,90000,10000,9874,true,"Varun Raj");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> expectedList= Stream.of(creditCard2,creditCard4).collect(Collectors.toList());

        when(jdbcTemplate.query(anyString(),any(Object[].class),any(MyBankService.CardMapper.class))).thenReturn(expectedList);

        List<CreditCard> actual = myBankService.apiByLimit(80000);

//        assertFalse(expectedList.size()==actual.size());
        assertEquals(expectedList,actual);
    }
    //@Test
    void testViewOne(){
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),100000,90000,10000,9874,true,"Varun Raj");

        when(jdbcTemplate.queryForObject(anyString(),any(Object[].class),any(BeanPropertyRowMapper.class))).thenReturn(creditCard1);

        Optional<CreditCard> actualOne = myBankService.apiFindById(creditCard1.getCreditcardNumber());

//        assertNull(actualOne.get());
        assertEquals(creditCard1.getCreditcardHolder(),actualOne.get().getCreditcardHolder());
        assertNotSame(creditCard2.getCreditcardCvv(),actualOne.get().getCreditcardCvv());
    }

    //@Test
    void testViewAll() throws SQLSyntaxErrorException {
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/2/2029"),91000,10000,81000,1111,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),100000,90000,10000,9874,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),50000,20000,30000,1384,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),200000,150000,50000,9474,true,"Akash");

        List<CreditCard> expectedList= Stream.of(creditCard2,creditCard3,creditCard4).collect(Collectors.toList());

        when(jdbcTemplate.query(anyString(),any(MyBankService.CardMapper.class))).thenReturn(expectedList);

        List<CreditCard> actualList = myBankService.apiFindAll();

        assertSame(expectedList.size(),actualList.size());
//        assertNull(actualList.get(4));
        assertNotSame(11111122343L,actualList.get(0).getCreditcardNumber());
    }
}
