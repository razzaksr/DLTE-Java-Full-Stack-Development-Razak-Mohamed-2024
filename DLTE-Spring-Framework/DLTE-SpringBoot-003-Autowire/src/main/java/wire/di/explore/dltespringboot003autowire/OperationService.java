package wire.di.explore.dltespringboot003autowire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    private Operations operations;

//    @Autowired
//    public OperationService(Operations operations){
//        this.operations=operations;
//    }

    public OperationService(){}

    @Autowired
    public OperationService(@Qualifier("bondOperation") Operations operations){
        this.operations=operations;
    }

    @Autowired
    @Qualifier("loanOperation")
    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public int callLiearSearch(double data){
        return operations.linearSearch(data);
    }
}
