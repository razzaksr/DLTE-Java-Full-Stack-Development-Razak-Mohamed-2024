package elements.spring.explore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class RestAPISecurityTest {
    @MockBean
    private MyBankService myBankService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "akash", authorities = {"admin"})
    void testApproval1() throws Exception {
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


        mockMvc.perform(post("/credit/new").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "akash", authorities = {"cashier"})
    void testApproval2() throws Exception {
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


        mockMvc.perform(post("/credit/new").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk());
    }

    @WithMockUser(username = "sanath",authorities = {"clerk","admin"})
    @Test
    void testFetchById1() throws Exception {
        mockMvc.perform(get("/credit/one/11111122343")).
                andExpect(status().isOk());
    }

    @WithMockUser(username = "sanath",authorities = {"manager","cashier"})
    @Test
    void testFetchById2() throws Exception {
        mockMvc.perform(get("/credit/one/11111122343")).
                andExpect(status().isUnauthorized());
    }

    @WithMockUser(username = "sanath",authorities = {"admin"})
    @Test
    void testFetchById3() throws Exception {
        mockMvc.perform(get("/credit/one/11111122343")).
                andExpect(status().isUnauthorized());
    }

    @Test
    void testFetchById4() throws Exception {
        mockMvc.perform(get("/credit/one/11111122343")).
                andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "razak",authorities = {"admin"})
    void testFetchAllEndpoint1() throws Exception {
        mockMvc.perform(get("/credit/view")).
                andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "razak",authorities = {"admin","manager"})
    void testFetchAllEndPoint2() throws Exception {
        mockMvc.perform(get("/credit/view")).
                andExpect(status().isForbidden());
    }
    @Test
    @WithMockUser(username = "razak",authorities = {"admin","manager"})
    void testFetchAllEndPoint3() throws Exception {
        mockMvc.perform(get("/credit/view")).
                andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "razak",authorities = {"manager","admin"})
    void testFetchAllEndPoint4() throws Exception {
        mockMvc.perform(get("/credit/view")).
                andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "razak",authorities = {"manager","admin","clerk"})
    void testFetchAllEndPoint5() throws Exception {
        mockMvc.perform(get("/credit/view")).
                andExpect(status().isForbidden());
    }
}
