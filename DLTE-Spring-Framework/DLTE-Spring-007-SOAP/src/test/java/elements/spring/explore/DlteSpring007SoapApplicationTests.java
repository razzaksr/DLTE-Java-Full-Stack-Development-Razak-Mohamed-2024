package elements.spring.explore;

import elements.spring.explore.configs.SoapPhase;
import elements.spring.explore.dao.Loans;
import elements.spring.explore.dao.LoansService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import services.loans.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DlteSpring007SoapApplicationTests {

    @MockBean
    private LoansService loansService;
    @InjectMocks
    private SoapPhase soapPhase;

    @Test
    public void testClosingLoan(){
        when(loansService.closeLoan(anyLong())).thenReturn("5678765 has closed");

        CloseLoanRequest request=new CloseLoanRequest();
        request.setLoanId(5678765L);
        CloseLoanResponse response=soapPhase.closingLoan(request);

        //assertFalse(response.getServiceStatus().getMessage().equals("5678765 has closed"));
//        assertEquals("6567656 Invalid loan",response.getServiceStatus().getMessage());
        assertTrue(response.getServiceStatus().getMessage().equals("5678765 has closed"));
    }

    @Test
    public void testUpdateLoan(){
        Loans loans3=new Loans(5678765L,98000,"Prashant",12,35.1,178000);
        Loans loans4=new Loans(6567656L,245000,"Annapoorna",60,35.1,500000);
        when(loansService.updateLoans(any(Loans.class))).thenReturn(loans4);

        UpdateLoanRequest request=new UpdateLoanRequest();
        services.loans.Loans loans=new services.loans.Loans();
        loans.setLoanId(6567656L);loans.setLoanPrinciple(245000);loans.setLoanBorrower("Annapoorna");
        loans.setLoanTenure(60);loans.setLoanInterest(35.1);loans.setLoanPayable(500000);
        request.setLoans(loans);

        UpdateLoanResponse response= soapPhase.updatingLoan(request);

        assertEquals(loans3.getLoanInterest(),response.getLoans().getLoanInterest());
        assertNotNull(response.getServiceStatus().getMessage());
//        assertTrue(loans3.getLoanTenure()==response.getLoans().getLoanTenure());
    }

    @Test
    public void testFilterByTenure(){
        Loans loans2=new Loans(8765678L,450000,"Divija",20,35.1,769999);
        Loans loans3=new Loans(5678765L,98000,"Prashant",12,35.1,178000);
        List<Loans> expectedLoans=Stream.of(loans2,loans3).collect(Collectors.toList());

        when(loansService.readByTenure(anyInt(),anyInt())).thenReturn(expectedLoans);

        FilterByTenureRequest request=new FilterByTenureRequest();
        request.setMinTenure(10);request.setMaxTenure(20);
        FilterByTenureResponse response=soapPhase.filterTenure(request);

        assertEquals(loans3.getLoanPrinciple(),response.getLoans().get(1).getLoanPrinciple());
//        assertFalse(loans2.getLoanId()!=response.getLoans().get(1).getLoanId());
        assertTrue(loans2.getLoanId()!=response.getLoans().get(1).getLoanId());
    }

    @Test
    public void testNewLoan(){
        Loans loans3=new Loans(5678765L,98000,"Prashant",12,35.1,178000);
        Loans loans4=new Loans(6567656L,245000,"Annapoorna",60,35.1,500000);
        when(loansService.publishNewLoan(any(Loans.class))).thenReturn(loans3);

        NewLoanRequest request=new NewLoanRequest();
        services.loans.Loans loans=new services.loans.Loans();
        loans.setLoanId(5678765L);
        loans.setLoanPayable(178000);
        loans.setLoanInterest(35.1);
        loans.setLoanTenure(12);
        loans.setLoanBorrower("Prashant");
        loans.setLoanPrinciple(98000);
        request.setLoans(loans);

        NewLoanResponse response= soapPhase.addNewLoan(request);

//        assertNull(response.getLoans());
        assertNotNull(response.getLoans());
//        assertEquals(245000,response.getLoans().getLoanPrinciple());
        assertTrue(loans3.getLoanBorrower().equals(response.getLoans().getLoanBorrower()));
        assertEquals("SUCCESS",response.getServiceStatus().getStatus());
    }

    @Test
    public void testListAllEndpoint(){
        Loans loans1=new Loans(976223L,120000,"Eeksha",24,35.1,400000);
        Loans loans2=new Loans(8765678L,450000,"Divija",20,35.1,769999);
        Loans loans3=new Loans(5678765L,98000,"Prashant",12,35.1,178000);
        Loans loans4=new Loans(6567656L,245000,"Annapoorna",60,35.1,500000);
        List<Loans> loans= Stream.of(loans1,loans2,loans3).collect(Collectors.toList());
        when(loansService.viewEvery()).thenReturn(loans);

        ViewAllLoansRequest request=new ViewAllLoansRequest();
        ViewAllLoansResponse response= soapPhase.listLoans(request);

        assertEquals("SUCCESS",response.getServiceStatus().getStatus());
//        assertSame(4,response.getLoans().size());
        assertTrue(loans.get(1).getLoanId()==response.getLoans().get(1).getLoanId());
    }

}
