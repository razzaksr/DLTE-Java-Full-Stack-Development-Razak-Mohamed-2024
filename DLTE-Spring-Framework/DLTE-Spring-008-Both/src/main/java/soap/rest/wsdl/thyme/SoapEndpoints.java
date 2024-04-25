package soap.rest.wsdl.thyme;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.loans.*;

@Endpoint
//@CrossOrigin(origins = "*")
public class SoapEndpoints {
    @Autowired
    private LoansRepository loansRepository;

    private final String url="http://loans.services";

    @PayloadRoot(namespace = url,localPart = "callDeletionRequest")
    @ResponsePayload
    public CallDeletionResponse deletionByCall(@RequestPayload CallDeletionRequest callDeletionRequest){
        CallDeletionResponse deletionResponse=new CallDeletionResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        String info = loansRepository.deleteById(callDeletionRequest.getLoanNumber());
        if(info==null){
            serviceStatus.setStatus("no loan found");
            serviceStatus.setMessage("no loan found");
        }
        else {
            serviceStatus.setStatus("success");
            serviceStatus.setMessage(info);
        }
        deletionResponse.setServiceStatus(serviceStatus);
        return deletionResponse;
    }
    @PayloadRoot(namespace = url, localPart = "updateLoanRequest")
    @ResponsePayload
    public UpdateLoanResponse updatingLoan(@RequestPayload UpdateLoanRequest updateLoanRequest){
        UpdateLoanResponse updateLoanResponse=new UpdateLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        services.loans.Loans loans=new services.loans.Loans();

        Loans daoLoan=new Loans();
        BeanUtils.copyProperties(updateLoanRequest.getLoans(),daoLoan);

        daoLoan = loansRepository.update(daoLoan);

        if(daoLoan!=null){
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage(daoLoan.getLoanNumber()+" has updated loan details");
        }
        else{
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage(daoLoan.getLoanNumber()+" hasn't updated loan details");
        }

        BeanUtils.copyProperties(daoLoan,loans);

        updateLoanResponse.setServiceStatus(serviceStatus);
        updateLoanResponse.setLoans(loans);

        return updateLoanResponse;
    }
}
