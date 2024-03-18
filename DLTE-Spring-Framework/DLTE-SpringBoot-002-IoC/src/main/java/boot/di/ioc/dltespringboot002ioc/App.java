package boot.di.ioc.dltespringboot002ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyBankConfigs.class);
        Bank bank1 = context.getBean(Bank.class);
        System.out.println(bank1);
        Bank bank2=context.getBean("mybank2",Bank.class);
        System.out.println(bank2);
    }
}
