package layer.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoApplication.class, args);
//		ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(DaoApplication.class, args);
//		BankersRepository repository = configurableApplicationContext.getBean(BankersRepository.class);
//		System.out.println(repository.listAll());
	}

}
