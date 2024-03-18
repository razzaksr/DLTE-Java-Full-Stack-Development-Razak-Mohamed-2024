package boot.di.ioc.dltespringboot002ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("boot.di.ioc.dltespringboot002ioc")
public class MyBankConfigs {
    @Bean
    public Bank getBank(){
        return new Bank();
    }
    @Bean(autowireCandidate = false,name = "mybank2")
    public Bank getBanks(){
        return new Bank("My Bank","Mumbai","mybank002");
    }
}
