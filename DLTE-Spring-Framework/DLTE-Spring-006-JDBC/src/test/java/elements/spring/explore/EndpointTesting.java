package elements.spring.explore;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.SQLSyntaxErrorException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EndpointTesting {
    @MockBean
    private MyBankService myBankService;

    @InjectMocks
    private MyBankController myBankController;

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void testBlock() throws Exception {
//        when(myBankService.apiBlock(eq(11111122343L),eq(9100))).thenReturn("11111122343 card is blocked");
//        mockMvc.perform(delete("/credit/block/1/9100")).
//                andExpect(status().isOk());
//
//    }

    //@Test
    void testApproval() throws Exception {
        String request="{\n" +
                "    \"creditcardNumber\": 56787676767,\n" +
                "    \"creditcardCvv\": 932,\n" +
                "    \"creditcardExpiry\": \"2035-10-21\",\n" +
                "    \"creditcardPin\": 984,\n" +
                "    \"creditcardLimit\": 50000,\n" +
                "    \"creditcardUsage\": 11500,\n" +
                "    \"creditcardAvailable\": 38500,\n" +
                "    \"creditcardStatus\": true,\n" +
                "    \"creditcardHolder\": \"Medhini\"\n" +
                "}";

        CreditCard creditCard=new CreditCard(56787676767L,932,new Date("10/21/2035"),9844,50000,11500,38500,true,"Medhini");
        when(myBankService.apiSave(any())).thenReturn(creditCard);

        mockMvc.perform(post("/credit/new").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk());
//        mockMvc.perform(post("/credit/new").contentType(MediaType.APPLICATION_JSON).content(request))
//                .andExpect(status().isOk()).
//                andExpect(jsonPath("$.creditcardNumber").value(11111122343L)).
//                andExpect(jsonPath("$.creditcardCvv").value(383)).
//                andExpect(jsonPath("$.creditcardExpiry").value("2029-11-30T18:30:00.000+00:00")).
//                andExpect(jsonPath("$.creditcardPin").value(9100)).
//                andExpect(jsonPath("$.creditcardLimit").value(10000)).
//                andExpect(jsonPath("$.creditcardUsage").value(8000)).
//                andExpect(jsonPath("$.creditcardAvailable").value(2000)).
//                andExpect(jsonPath("$.creditcardStatus").value(false)).
//                andExpect(jsonPath("$.creditcardHolder").value("Annapoorna Pai"))
//        ;
    }

    //@Test
    void testFetchById() throws Exception {
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/1/2029"),9100,10000,8000,2000,false,"Annapoorna Pai");
        when(myBankService.apiFindById(eq(11111122343L))).thenReturn(Optional.of(creditCard1));
        mockMvc.perform(get("/credit/one/11111122343")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.creditcardNumber").value(11111122343L)).
                andExpect(jsonPath("$.creditcardCvv").value(383)).
                andExpect(jsonPath("$.creditcardExpiry").value("2029-11-30T18:30:00.000+00:00")).
                andExpect(jsonPath("$.creditcardPin").value(9100)).
                andExpect(jsonPath("$.creditcardLimit").value(10000)).
                andExpect(jsonPath("$.creditcardUsage").value(8000)).
                andExpect(jsonPath("$.creditcardAvailable").value(2000)).
                andExpect(jsonPath("$.creditcardStatus").value(false)).
                andExpect(jsonPath("$.creditcardHolder").value("Annapoorna Pai"));
    }

    //@Test
    void testFetchAllEndpoint() throws Exception {
        CreditCard creditCard1=new CreditCard(11111122343L,383,new Date("12/1/2029"),9100,10000,8000,2000,false,"Annapoorna Pai");
        CreditCard creditCard2=new CreditCard(98767767673L,123,new Date("10/4/2034"),4563,90000,10000,80000,true,"Varun Raj");
        CreditCard creditCard3=new CreditCard(45623536435L,564,new Date("9/28/2030"),1122,20000,3000,17000,true,"Divija");
        CreditCard creditCard4=new CreditCard(87673448747L,445,new Date("8/12/2031"),4455,150000,50000,100000,true,"Akash");

        List<CreditCard> expectedList= Stream.of(creditCard1,creditCard3,creditCard4).collect(Collectors.toList());
        //System.out.println(expectedList);

        when(myBankService.apiFindAll()).thenReturn(expectedList);

        mockMvc.perform(get("/credit/view")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$[0].creditcardNumber").value(11111122343L)).
                andExpect(jsonPath("$[0].creditcardCvv").value(383)).
                andExpect(jsonPath("$[0].creditcardExpiry").value("2029-11-30T18:30:00.000+00:00")).
                andExpect(jsonPath("$[0].creditcardPin").value(9100)).
                andExpect(jsonPath("$[0].creditcardLimit").value(10000)).
                andExpect(jsonPath("$[0].creditcardUsage").value(8000)).
                andExpect(jsonPath("$[0].creditcardAvailable").value(2000)).
                andExpect(jsonPath("$[0].creditcardStatus").value(false)).
                andExpect(jsonPath("$[0].creditcardHolder").value("Annapoorna Pai")).
                andExpect(jsonPath("$[1].creditcardNumber").value(creditCard3.getCreditcardNumber())).
                andExpect(jsonPath("$[1].creditcardCvv").value(creditCard3.getCreditcardCvv())).
                andExpect(jsonPath("$[1].creditcardExpiry").value("2030-09-27T18:30:00.000+00:00")).
                andExpect(jsonPath("$[1].creditcardPin").value(creditCard3.getCreditcardPin())).
                andExpect(jsonPath("$[1].creditcardLimit").value(creditCard3.getCreditcardLimit())).
                andExpect(jsonPath("$[1].creditcardUsage").value(creditCard3.getCreditcardUsage())).
                andExpect(jsonPath("$[1].creditcardAvailable").value(creditCard3.getCreditcardAvailable())).
                andExpect(jsonPath("$[1].creditcardStatus").value(creditCard3.isCreditcardStatus())).
                andExpect(jsonPath("$[1].creditcardHolder").value(creditCard3.getCreditcardHolder()))
        ;

//        mockMvc.perform(get("/credit/view")).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("$[0].creditcardNumber").value(11111122343L)).
//                andExpect(jsonPath("$[0].creditcardCvv").value(383)).
//                andExpect(jsonPath("$[0].creditcardExpiry").value("2029-11-30T18:30:00.000+00:00")).
//                andExpect(jsonPath("$[0].creditcardPin").value(9100)).
//                andExpect(jsonPath("$[0].creditcardLimit").value(10000)).
//                andExpect(jsonPath("$[0].creditcardUsage").value(8000)).
//                andExpect(jsonPath("$[0].creditcardAvailable").value(2000)).
//                andExpect(jsonPath("$[0].creditcardStatus").value(false)).
//                andExpect(jsonPath("$[0].creditcardHolder").value("Annapoorna Pai")).
//                andExpect(jsonPath("$[1].creditcardNumber").value(creditCard2.getCreditcardNumber())).
//                andExpect(jsonPath("$[1].creditcardCvv").value(creditCard2.getCreditcardCvv())).
//                andExpect(jsonPath("$[1].creditcardExpiry").value(creditCard2.getCreditcardExpiry().getTime())).
//                andExpect(jsonPath("$[1].creditcardPin").value(creditCard2.getCreditcardPin())).
//                andExpect(jsonPath("$[1].creditcardLimit").value(creditCard2.getCreditcardLimit())).
//                andExpect(jsonPath("$[1].creditcardUsage").value(creditCard2.getCreditcardUsage())).
//                andExpect(jsonPath("$[1].creditcardAvailable").value(creditCard2.getCreditcardAvailable())).
//                andExpect(jsonPath("$[1].creditcardStatus").value(creditCard2.isCreditcardStatus())).
//                andExpect(jsonPath("$[1].creditcardHolder").value(creditCard2.getCreditcardHolder()))
//        ;

    }

}
