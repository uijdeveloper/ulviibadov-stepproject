package az.abbtech.phonebook.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PhonebookFinalFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookFinalFrontendApplication.class, args);
	}

}
