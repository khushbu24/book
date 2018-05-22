package book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan( basePackages = {"com.country","com.country.controller"})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
