package wire.di.explore.dltespringboot003autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExecutingFieldInjection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.scan("wire.di.explore.dltespringboot003autowire");
        context.refresh();
        OptimalService optimalService = context.getBean(OptimalService.class);
        System.out.println(optimalService.executeSearch(4.5));

    }
}
