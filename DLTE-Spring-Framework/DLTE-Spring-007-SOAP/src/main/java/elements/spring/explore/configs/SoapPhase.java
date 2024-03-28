package elements.spring.explore.configs;

import elements.spring.explore.dao.Loans;
import elements.spring.explore.dao.LoansService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.loans.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class SoapPhase {
    private final String url="http://loans.services";
    @Autowired
    private LoansService loansService;

    @PayloadRoot(namespace = url,localPart = "callDeletionRequest")
    @ResponsePayload
    public CallDeletionResponse deletionByCall(@RequestPayload CallDeletionRequest callDeletionRequest){
        CallDeletionResponse deletionResponse=new CallDeletionResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        String message = loansService.proceduralDelete(callDeletionRequest.getLoanId());
        if(message.contains("Invalid loan"))
            serviceStatus.setStatus("FAILURE");
        else
            serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage(message);
        deletionResponse.setServiceStatus(serviceStatus);
        return deletionResponse;
    }

    @PreAuthorize("hasAnyAuthority('admin','manager')")
    @PayloadRoot(namespace = url, localPart = "closeLoanRequest")
    @ResponsePayload
    public CloseLoanResponse closingLoan(@RequestPayload CloseLoanRequest closeLoanRequest){
        CloseLoanResponse response=new CloseLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        String fromDAO = loansService.closeLoan(closeLoanRequest.getLoanId());
        if(fromDAO.contains("Invalid")){
            serviceStatus.setStatus("FAILURE");
        }
        else
            serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage(fromDAO);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PreAuthorize("hasAuthority('admin')")
    @PayloadRoot(namespace = url, localPart = "updateLoanRequest")
    @ResponsePayload
    public UpdateLoanResponse updatingLoan(@RequestPayload UpdateLoanRequest updateLoanRequest){
        UpdateLoanResponse updateLoanResponse=new UpdateLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        services.loans.Loans loans=new services.loans.Loans();

        Loans daoLoan=new Loans();
        BeanUtils.copyProperties(updateLoanRequest.getLoans(),daoLoan);

        daoLoan = loansService.updateLoans(daoLoan);

        if(daoLoan!=null){
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage(daoLoan.getLoanBorrower()+" has updated loan details");
        }
        else{
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage(daoLoan.getLoanBorrower()+" hasn't updated loan details");
        }

        BeanUtils.copyProperties(daoLoan,loans);

        updateLoanResponse.setServiceStatus(serviceStatus);
        updateLoanResponse.setLoans(loans);

        return updateLoanResponse;
    }

    @PreAuthorize("hasAuthority('clerk')")
    @PayloadRoot(namespace = url,localPart = "filterByTenureRequest")
    @ResponsePayload
    public FilterByTenureResponse filterTenure(@RequestPayload FilterByTenureRequest filterByTenureRequest){
        FilterByTenureResponse filterByTenureResponse=new FilterByTenureResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        List<services.loans.Loans> returnLoans = new ArrayList<>();

        List<Loans> received = loansService.readByTenure(filterByTenureRequest.getMinTenure(), filterByTenureRequest.getMaxTenure());

        Iterator<Loans> iterator= received.iterator();

        while(iterator.hasNext()){
            services.loans.Loans currentLoans=new services.loans.Loans();
            BeanUtils.copyProperties(iterator.next(),currentLoans);
            returnLoans.add(currentLoans);
        }

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Loan's were fetched");

        filterByTenureResponse.setServiceStatus(serviceStatus);
        filterByTenureResponse.getLoans().addAll(returnLoans);

        return  filterByTenureResponse;
    }

    @PreAuthorize("hasAnyAuthority('admin','manager')")
    @PayloadRoot(namespace = url,localPart = "newLoanRequest")
    @ResponsePayload
    public NewLoanResponse addNewLoan(@RequestPayload NewLoanRequest newLoanRequest){
        NewLoanResponse newLoanResponse=new NewLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        services.loans.Loans actual= newLoanRequest.getLoans();
        Loans daoLoan=new Loans();
        BeanUtils.copyProperties(actual,daoLoan);

        daoLoan = loansService.publishNewLoan(daoLoan);

        if(daoLoan!=null){
            serviceStatus.setStatus("SUCCESS");
            BeanUtils.copyProperties(daoLoan,actual);
            newLoanResponse.setLoans(actual);
            serviceStatus.setMessage(actual.getLoanId()+" has inserted");
        }
        else{
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage(actual.getLoanId()+" hasn't inserted");
        }
        newLoanResponse.setServiceStatus(serviceStatus);
        return newLoanResponse;
    }

    @PreAuthorize("hasAnyAuthority('clerk','cashier')")
    @PayloadRoot(namespace = url,localPart = "viewAllLoansRequest")
    @ResponsePayload
    public ViewAllLoansResponse listLoans(@RequestPayload ViewAllLoansRequest viewAllLoansRequest){
        ViewAllLoansResponse viewAllLoansResponse=new ViewAllLoansResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        // loans>> dao
        List<Loans> fromDao=loansService.viewEvery();
//        System.out.println(fromDao.toString());

        // soap Loan
        List<services.loans.Loans> actualLoans=new ArrayList<>();

        Iterator<Loans> iterator= fromDao.iterator();

        while(iterator.hasNext()){
            services.loans.Loans currentLoans=new services.loans.Loans();
            BeanUtils.copyProperties(iterator.next(),currentLoans);
            actualLoans.add(currentLoans);
        }

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Loan's were fetched");

        viewAllLoansResponse.setServiceStatus(serviceStatus);
        viewAllLoansResponse.getLoans().addAll(actualLoans);

        //System.out.println(viewAllLoansResponse.getLoans().toString());

        return viewAllLoansResponse;
    }
}
