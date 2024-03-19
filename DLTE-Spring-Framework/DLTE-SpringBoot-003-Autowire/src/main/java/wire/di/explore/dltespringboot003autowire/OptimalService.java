package wire.di.explore.dltespringboot003autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OptimalService {
    @Autowired
    @Qualifier("bondOperation")
    private Operations operations;

    public int executeSearch(double data){
        return operations.linearSearch(data);
    }
}
