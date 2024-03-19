package wire.di.explore.dltespringboot003autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bondOperation")
public class MyBondImplementation implements Operations{
    @Override
    public int linearSearch(double data) {
        for(int index=2;index< myBase.length-2;index++){
            if(myBase[index]==data)
                return index;
        }
        return -1;
    }
}
