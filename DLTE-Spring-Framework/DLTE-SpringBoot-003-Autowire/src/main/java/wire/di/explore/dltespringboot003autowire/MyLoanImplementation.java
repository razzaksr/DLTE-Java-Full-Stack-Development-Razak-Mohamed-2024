package wire.di.explore.dltespringboot003autowire;

import org.springframework.stereotype.Component;

@Component("loanOperation")
public class MyLoanImplementation implements Operations{

    @Override
    public int linearSearch(double data) {
        for(int index=0;index< myBase.length;index++){
            if(myBase[index]==data)
                return index;
        }
        return -1;
    }
}
